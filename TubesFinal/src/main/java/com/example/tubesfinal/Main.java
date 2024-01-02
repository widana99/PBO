package com.example.tubesfinal;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Sparepart sparepart1 = new Sparepart("Mesin", "Busi", 30000, 100);
        Sparepart sparepart2 = new Sparepart("Knalpot", "Katalistator", 500000, 79);
        Sparepart sparepart3 = new Sparepart("Rem", "Kampas Rem", 300000, 150);
        Sparepart sparepart4 = new Sparepart("Suspensi", "Per Suspensi", 350000, 200);
        Sparepart sparepart5 = new Sparepart("Transmisi", "Flywheel", 400000, 185);

        System.out.print("Nama: ");
        String namaPelanggan = scanner.nextLine();
        System.out.print("Alamat: ");
        String alamatPelanggan = scanner.nextLine();

        Pelanggan pelanggan = new Pelanggan(namaPelanggan, alamatPelanggan, 0);

        System.out.print("Tanggal Pemesanan (yyyy-mm-dd): ");
        Date tanggalPembelian = new nextLine();

        System.out.println("\nPelanggan " + pelanggan.nama + " Ingin Membeli: ");
        System.out.println("1. " + sparepart1.nama + " Dengan Jenis: " + sparepart1.jenis + " Pricelist: Rp." + sparepart1.hargaPerUnit + "/unit - Stok: " + sparepart1.stok);
        System.out.println("2. " + sparepart2.nama + " Dengan Jenis: " + sparepart2.jenis + " Pricelist: Rp." + sparepart2.hargaPerUnit + "/unit - Stok: " + sparepart2.stok);
        System.out.println("3. " + sparepart3.nama + " Dengan Jenis: " + sparepart3.jenis + " Pricelist: Rp." + sparepart3.hargaPerUnit + "/unit - Stok: " + sparepart3.stok);
        System.out.println("4. " + sparepart4.nama + " Dengan Jenis: " + sparepart4.jenis + " Pricelist: Rp." + sparepart4.hargaPerUnit + "/unit - Stok: " + sparepart4.stok);
        System.out.println("5. " + sparepart5.nama + " Dengan Jenis: " + sparepart5.jenis + " Pricelist: Rp." + sparepart5.hargaPerUnit + "/unit - Stok: " + sparepart5.stok);

        System.out.print("Berapa Sparepart Yang Anda Ingin Beli: ");
        int nomorSparepart = 0;
        try {
            nomorSparepart = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("MOHON MASUKKAN DENGAN ANGKA!");
            scanner.close();
            System.exit(0);
        }

        System.out.print("Berapa jumlah Sparepart yang anda ingin dibeli: ");
        int jumlahPembelian = 0;
        try {
            jumlahPembelian = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("MOHON MASUKKAN JUMLAH SPAREPART DENGAN ANGKA!");
            scanner.close();
            System.exit(0);
        }

        Sparepart sparepartpilihan = null;
        String Namasparepartpilihan = null;

        switch (nomorSparepart){
            case 1:
                sparepartpilihan = sparepart1;
                Namasparepartpilihan = sparepart1.nama;
                break;
            case 2:
                sparepartpilihan = sparepart2;
                Namasparepartpilihan = sparepart2.nama;
                break;
            case 3:
                sparepartpilihan = sparepart3;
                Namasparepartpilihan = sparepart3.nama;
                break;
            case 4:
                sparepartpilihan = sparepart4;
                Namasparepartpilihan = sparepart4.nama;
                break;
            case 5:
                sparepartpilihan = sparepart5;
                Namasparepartpilihan = sparepart4.nama;
            default:
                System.out.println("NOMOR SPAREPART TIDAK VALID!.");
                scanner.close();
                System.exit(0);
        }

        if (jumlahPembelian > sparepartpilihan.stok) {
            System.out.println("JUMLAH YANG ANDA MASUKI MELEBIHI STOK KAMI!");
            scanner.close();
            System.exit(0);
        }

        PembelianSparepart pembelianSparepart = new PembelianSparepart(tanggalPembelian, sparepartpilihan, jumlahPembelian,
                jumlahPembelian * sparepartpilihan.hargaPerUnit, 0);

        double diskon = pembelianSparepart.hitungDiskon(pembelianSparepart.getTotalharga());
        pembelianSparepart.setTotalharga(pembelianSparepart.getTotalharga() - diskon);

        if (sparepartpilihan != null) {
            sparepartpilihan.setStok(sparepartpilihan.getStok() - pembelianSparepart.getJumlah());

            System.out.println("\nTransaksi Pembelian Obat");
            System.out.println("Tanggal: " + pembelianSparepart.getTanggal());
            System.out.println("Sparepart: " + sparepartpilihan.getNama());
            System.out.println("Jumlah: " + pembelianSparepart.getJumlah());
            System.out.println("Total Harga: Rp " + pembelianSparepart.getTotalharga());
            System.out.println("Diskon: Rp " + diskon);
            System.out.println("Stok SparePart Tersisa: " + sparepartpilihan.getStok());
        }
        scanner.close();
    }

    private static class nextLine extends Date {
    }
}