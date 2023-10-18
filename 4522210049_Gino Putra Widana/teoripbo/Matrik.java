package teoripbo;

public class Matrik {
    public Pecahan[][] data;
    private int baris;
    private int kolom;

    public Matrik(int baris, int kolom) {
        this.baris = baris;
        this.kolom = kolom;
        data = new Pecahan[baris][kolom];
    }

    public void tambah(Matrik other) {
        if (this.baris != other.baris || this.kolom != other.kolom) {
            System.out.println("Matriks tidak dapat dijumlahkan. Ukuran berbeda.");
            return;
        }

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                data[i][j] = data[i][j].tambah(other.data[i][j]);
            }
        }
    }

    public void kurang(Matrik other) {
        if (this.baris != other.baris || this.kolom != other.kolom) {
            System.out.println("Matriks tidak dapat dikurangkan. Ukuran berbeda.");
            return;
        }

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                data[i][j] = data[i][j].kurang(other.data[i][j]);
            }
        }
    }

    public Matrik dot(Matrik other) {
        if (this.kolom != other.baris) {
            System.out.println("Matriks tidak dapat di-dot. Ukuran tidak sesuai.");
            return null;
        }

        Matrik result = new Matrik(this.baris, other.kolom);

        for (int i = 0; i < this.baris; i++) {
            for (int j = 0; j < other.kolom; j++) {
                Pecahan sum = new Pecahan(0, 1);
                for (int k = 0; k < this.kolom; k++) {
                    sum = sum.tambah(this.data[i][k].kali(other.data[k][j]));
                }
                result.data[i][j] = sum;
            }
        }

        return result;
    }

    public Matrik transpose() {
        Matrik result = new Matrik(this.kolom, this.baris);

        for (int i = 0; i < this.baris; i++) {
            for (int j = 0; j < this.kolom; j++) {
                result.data[j][i] = this.data[i][j];
            }
        }

        return result;
    }

    public Matrik inverse() {
        if (this.baris != this.kolom) {
            System.out.println("Matriks tidak dapat diinvers. Bukan matriks persegi.");
            return null;
        }

        int n = this.baris;
        Matrik augmentedMatriks = new Matrik(n, 2 * n);

        // Membuat matriks augmented yang berisi matriks asli dan matriks identitas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatriks.data[i][j] = this.data[i][j];
                augmentedMatriks.data[i][j + n] = (i == j) ? new Pecahan(1, 1) : new Pecahan(0, 1);
            }
        }

        // Implementasi eliminasi Gauss-Jordan di sini untuk menghasilkan matriks invers

        // ...

        return null; // Anda perlu mengganti ini dengan hasil invers yang benar
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                result.append(data[i][j]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}