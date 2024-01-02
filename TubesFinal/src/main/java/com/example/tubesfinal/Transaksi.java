package com.example.tubesfinal;

import java.util.Date;

public abstract class Transaksi {
    Date tanggal;
    String sparepart;
    int jumlah;
    double totalharga;
    double diskon;
    public Transaksi(Date tanggal, String sparepart, int jumlah, double totalharga, double diskon){
        this.tanggal = tanggal;
        this.sparepart = sparepart;
        this.jumlah = jumlah;
        this.totalharga = totalharga;
        this.diskon = diskon;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTotalharga(double totalharga) {
        this.totalharga = totalharga;
    }

    public String getSparepart() {
        return sparepart;
    }
    public int getJumlah(){
        return jumlah;
    }

    public double getTotalharga() {
        return totalharga;
    }

    public double getDiskon() {
        return diskon;
    }
    public abstract double hitungDiskon(double totalharga);
}

