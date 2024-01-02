package com.example.tubesfinal;

public class Sparepart {
    String nama;
    String jenis;
    double hargaPerUnit;
    int stok;
    public Sparepart(String nama, String jenis, double hargaPerUnit, int stok){
        this.nama = nama;
        this.jenis = jenis;
        this.hargaPerUnit = hargaPerUnit;
        this.stok = stok;
    }
    public String getNama(){
        return nama;
    }

    public double getHargaPerUnit() {
        return hargaPerUnit;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getJenis() {
        return jenis;
    }
}
