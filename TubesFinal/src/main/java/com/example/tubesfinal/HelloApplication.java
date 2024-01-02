package com.example.tubesfinal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Date;

public class HelloApplication extends Application {
    private Stage primaryStage;
    private VBox layout;
    private Label resultLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        Sparepart sparepart1 = new Sparepart("Mesin", "Busi", 30000, 100);
        Sparepart sparepart2 = new Sparepart("Knalpot", "Katalistator", 500000, 79);
        Sparepart sparepart3 = new Sparepart("Rem", "Kampas Rem", 300000, 150);
        Sparepart sparepart4 = new Sparepart("Suspensi", "Per Suspensi", 350000, 200);
        Sparepart sparepart5 = new Sparepart("Transmisi", "Flywheel", 400000, 185);

        layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #f5f5f5;");

        Label headerLabel = new Label("Selamat Datang di Sparepart App");
        headerLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #3498db;");


        Label label = new Label("Nama: ");
        label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #424242;");
        TextField namaField = new TextField();
        namaField.setStyle("-fx-background-color: #ffffff; -fx-border-color: #9e9e9e;");

        Label alamatLabel = new Label("Alamat: ");
        alamatLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #424242;");
        TextField alamatField = new TextField();
        alamatField.setStyle("-fx-background-color: #ffffff; -fx-border-color: #9e9e9e;");

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #43a047; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;");
        submitButton.setOnAction(e -> {
            handleSubmission(namaField.getText(), alamatField.getText(), sparepart1, sparepart2, sparepart3, sparepart4, sparepart5);
        });

        layout.getChildren().addAll(label, namaField, alamatLabel, alamatField, submitButton);


        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sparepart App");
        primaryStage.show();
    }

    private void handleSubmission(String namaPelanggan, String alamatPelanggan, Sparepart... spareparts) {
        Pelanggan pelanggan = new Pelanggan(namaPelanggan, alamatPelanggan, 0);

        StringBuilder content = new StringBuilder();
        content.append("Pelanggan ").append(pelanggan.nama).append(" Ingin Membeli:\n");

        for (int i = 0; i < spareparts.length; i++) {
            content.append((i + 1)).append(". ").append(spareparts[i].getNama())
                    .append(" Dengan Jenis: ").append(spareparts[i].getJenis())
                    .append(" Pricelist: Rp.").append(spareparts[i].getHargaPerUnit())
                    .append("/unit - Stok: ").append(spareparts[i].getStok()).append("\n");
        }

        resultLabel = new Label(content.toString());
        layout.getChildren().clear();
        layout.getChildren().add(resultLabel);

        Label promptLabel = new Label("Pilih nomor sparepart yang ingin dibeli:");
        promptLabel.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: black;");
        TextField nomorField = new TextField();
        nomorField.setStyle("-fx-background-color: #ecf0f1; -fx-border-color: #bdc3c7;");

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        submitButton.setOnAction(e -> processSparepartSelection(nomorField.getText(), spareparts));

        layout.getChildren().addAll(promptLabel, nomorField, submitButton);
    }

    private void processSparepartSelection(String nomorSparepartText, Sparepart... spareparts) {
        int nomorSparepart = Integer.parseInt(nomorSparepartText);

        if (nomorSparepart < 1 || nomorSparepart > spareparts.length) {
            resultLabel.setText("Nomor sparepart tidak valid.");
        } else {
            Sparepart sparepartPilihan = spareparts[nomorSparepart - 1];

            Label jumlahLabel = new Label("Berapa jumlah sparepart yang Anda ingin beli:");
            jumlahLabel.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: black;");
            TextField jumlahField = new TextField();
            jumlahField.setStyle("-fx-background-color: #ecf0f1; -fx-border-color: #bdc3c7;");

            Button submitJumlahButton = new Button("Submit");
            submitJumlahButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
            submitJumlahButton.setOnAction(e -> processJumlahSubmission(jumlahField.getText(), sparepartPilihan));

            layout.getChildren().clear();
            layout.getChildren().addAll(resultLabel, jumlahLabel, jumlahField, submitJumlahButton);
        }
    }

    private void processJumlahSubmission(String jumlahText, Sparepart sparepartPilihan) {
        int jumlahPembelian = Integer.parseInt(jumlahText);

        if (jumlahPembelian > sparepartPilihan.getStok()) {
            resultLabel.setText("Jumlah yang Anda masukkan melebihi stok kami!");
        } else {
            Date tanggalPembelian = new Date(); // Tanggal pembelian saat ini

            PembelianSparepart pembelianSparepart = new PembelianSparepart(
                    tanggalPembelian, sparepartPilihan, jumlahPembelian,
                    jumlahPembelian * sparepartPilihan.getHargaPerUnit(), 0);

            double diskon = pembelianSparepart.hitungDiskon(pembelianSparepart.getTotalharga());
            pembelianSparepart.setTotalharga(pembelianSparepart.getTotalharga() - diskon);

            // Menampilkan detail transaksi
            showTransactionDetails(pembelianSparepart, sparepartPilihan.getStok() - jumlahPembelian);
        }
    }



    private void showTransactionDetails(PembelianSparepart pembelianSparepart, int stokSparepartTersisa) {
        resultLabel.setText("\nTransaksi Pembelian Sparepart\n" +
                "Tanggal: " + pembelianSparepart.getTanggal() + "\n" +
                "Sparepart: " + pembelianSparepart.getSparepart() + "\n" +
                "Jumlah: " + pembelianSparepart.getJumlah() + "\n" +
                "Total Harga: Rp " + pembelianSparepart.getTotalharga() + "\n" +
                "Diskon: Rp " + pembelianSparepart.getDiskon() + "\n" +
                "Stok Sparepart Tersisa: " + stokSparepartTersisa);

        VBox newLayout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #f5f5f5;");
        newLayout.getChildren().add(resultLabel);

        Scene newScene = new Scene(newLayout, 400, 300);
        primaryStage.setScene(newScene);
        primaryStage.setTitle("Hasil Transaksi");
        primaryStage.show();
    }

}
