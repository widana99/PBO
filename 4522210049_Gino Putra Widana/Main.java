import teoripbo.Matrik;
import teoripbo.Pecahan;

public class Main {
    public static void main(String[] args) {
        Pecahan pecahan1 = new Pecahan(5, 6);
        Pecahan pecahan2 = new Pecahan(3, 8);

        System.out.println("teoripbo.Pecahan 1: " + pecahan1);
        System.out.println("teoripbo.Pecahan 2: " + pecahan2);

        Pecahan hasilTambah = pecahan1.tambah(pecahan2);
        System.out.println("Hasil Penjumlahan: " + hasilTambah);

        Pecahan hasilKurang = pecahan1.kurang(pecahan2);
        System.out.println("Hasil Pengurangan: " + hasilKurang);

        Pecahan hasilKali = pecahan1.kali(pecahan2);
        System.out.println("Hasil Perkalian: " + hasilKali);

        Pecahan hasilBagi = pecahan1.bagi(pecahan2);
        System.out.println("Hasil Pembagian: " + hasilBagi);

        Matrik matriks1 = new Matrik(2, 2);
        matriks1.data[0][0] = pecahan1;
        matriks1.data[0][1] = pecahan2;
        matriks1.data[1][0] = pecahan1;
        matriks1.data[1][1] = pecahan2;

        Matrik matriks2 = new Matrik(2, 2);
        matriks2.data[0][0] = pecahan2;
        matriks2.data[0][1] = pecahan1;
        matriks2.data[1][0] = pecahan2;
        matriks2.data[1][1] = pecahan1;

        System.out.println("Matriks 1:");
        System.out.println(matriks1);

        System.out.println("Matriks 2:");
        System.out.println(matriks2);

        matriks1.tambah(matriks2);
        System.out.println("Hasil Penjumlahan Matriks:");
        System.out.println(matriks1);

        matriks1.kurang(matriks2);
        System.out.println("Hasil Pengurangan Matriks:");
        System.out.println(matriks1);

        matriks1.dot(matriks2);
        System.out.println("Hasil Dot Product Matriks:");
        System.out.println(matriks1);

        matriks1.transpose();
        System.out.println("Hasil Transpose Matriks:");
        System.out.println(matriks1);

        matriks1.inverse();
        System.out.println("Hasil Invers Matriks:");
        System.out.println(matriks2);
    }
}