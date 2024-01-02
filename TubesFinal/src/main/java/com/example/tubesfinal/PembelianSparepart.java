package com.example.tubesfinal;

import java.util.Date;

public class PembelianSparepart extends Transaksi {
    public PembelianSparepart(Date tanggal, Sparepart sparepart, int jumlah, double totalharga, double diskon){
        super(tanggal, String.valueOf(sparepart), jumlah, totalharga, diskon);
    }

    @Override
    public double hitungDiskon(double totalharga) {
        return totalharga >= 100000 ? 0.1 * totalharga : 0;
    }
}

