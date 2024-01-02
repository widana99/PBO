package com.example.tubesfinal;

import java.util.Date;

public class Pelanggan {
    String nama;
    String alamat;
    double saldoReward;
    public Pelanggan(String nama, String alamat, double saldoReward){
        this.nama = nama;
        this.alamat = alamat;
        this.saldoReward = saldoReward;
    }

    public double getSaldoReward() {
        return saldoReward;
    }

    public void setSaldoReward(double saldoReward) {
        this.saldoReward = saldoReward;
    }
}
