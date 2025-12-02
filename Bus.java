import java.util.ArrayList; // Menggunakan ArrayList sesuai opsi yang diizinkan 
import java.util.List;

public class Bus {
    // Konstanta (Static dan Final)
    // Ongkos bus adalah 2000 dan nilainya static dan final [cite: 48]
    static final int ONGKOS_BUS = 2000; 
    
    // Kapasitas Kursi dan Total (Berdasarkan observasi)
    private static final int MAX_KURSI_BIASA = 16; // 16 kursi penumpang biasa [cite: 6]
    private static final int MAX_KURSI_PRIORITAS = 4; // 4 kursi prioritas [cite: 6]
    private static final int MAX_PENUMPANG_BERDIRI = 20; // Kapasitas maks 40 orang, 20 kursi = 20 berdiri [cite: 7]
    private static final int MAX_KAPASITAS_BUS = MAX_KURSI_BIASA + MAX_KURSI_PRIORITAS + MAX_PENUMPANG_BERDIRI; // 40 orang [cite: 7]

    // Atribut (menggunakan List untuk kemudahan penambahan/penghapusan)
    // Penumpang Biasa: Penumpang [16] [cite: 21]
    private List<Penumpang> penumpangBiasa; 
    // Penumpang Prioritas: Penumpang [4] [cite: 22]
    private List<Penumpang> penumpangPrioritas; 
    // Penumpang Berdiri: Penumpang [20] [cite: 23]
    private List<Penumpang> penumpangBerdiri; 
    
    // Total pendapatan bus per hari bermula dari nilai 0 [cite: 49]
    private int totalPendapatan; 

    /**
     * Constructor Class Bus.
     * Menginisialisasi list penumpang dan total pendapatan.
     */
    public Bus() {
        this.penumpangBiasa = new ArrayList<>();
        this.penumpangPrioritas = new ArrayList<>();
        this.penumpangBerdiri = new ArrayList<>();
        this.totalPendapatan = 0; // Total pendapatan bus per hari bermula dari nilai 0 [cite: 49]
    }

    // Accessor Methods (Getter Methods) [cite: 27, 28, 29]
    public List<Penumpang> getPenumpangBiasa() {
        // Method getPenumpang....() mengembalikan list penumpang yang diminta [cite: 55]
        return penumpangBiasa;
    }

    public List<Penumpang> getPenumpangPrioritas() {
        // Method getPenumpang....() mengembalikan list penumpang yang diminta [cite: 55]
        return penumpangPrioritas;
    }

    public List<Penumpang> getPenumpangBerdiri() {
        // Method getPenumpang....() mengembalikan list penumpang yang diminta [cite: 55]
        return penumpangBerdiri;
    }

    // Accessor Methods (Getter for Count) [cite: 30, 31, 32]
    public int getJumlahPenumpangBiasa() {
        // Method getJumlah Penumpang....() mengembalikan jumlah penumpang yang diminta [cite: 55]
        return penumpangBiasa.size();
    }

    public int getJumlahPenumpangPrioritas() {
        // Method getJumlah Penumpang....() mengembalikan jumlah penumpang yang diminta [cite: 55]
        return penumpangPrioritas.size();
    }

    public int getJumlahPenumpangBerdiri() {
        // Method getJumlah Penumpang....() mengembalikan jumlah penumpang yang diminta [cite: 55]
        return penumpangBerdiri.size();
    }

    public int getTotalPenumpang() {
        return getJumlahPenumpangBiasa() + getJumlahPenumpangPrioritas() + getJumlahPenumpangBerdiri();
    }

    public int getTotalPendapatan() {
        return totalPendapatan;
    }

    /**
     * Method untuk menambahkan penumpang ke dalam Bus (selagi bus belum melebihi kapasitas).
     * @param penumpang Objek Penumpang yang akan naik.
     * @return true jika penumpang berhasil naik, false jika tidak.
     */
    public boolean naikkanPenumpang(Penumpang penumpang) {
        // Penumpang tidak bisa lagi menaiki bus jika bus sudah penuh [cite: 15]
        if (getTotalPenumpang() >= MAX_KAPASITAS_BUS) {
            System.out.println("Gagal: Bus sudah penuh (Kapasitas Maksimal: " + MAX_KAPASITAS_BUS + ").");
            return false; // Mengembalikan false jika penumpang tidak bisa naik [cite: 57]
        }

        // Saat penumpang naik juga perlu memastikan saldo kartu penumpang masih mencukupi untuk membayar ongkos bus [cite: 58]
        if (!penumpang.kurangiSaldo(ONGKOS_BUS)) {
            System.out.println("Gagal: Saldo tidak mencukupi untuk membayar ongkos bus (" + ONGKOS_BUS + "). Saldo saat ini: " + penumpang.getSaldo());
            return false;
        }

        // Tentukan tempat duduk/berdiri
        if (penumpang.isPrioritas()) {
            // Penumpang Prioritas: coba masuk ke Kursi Prioritas, lalu Kursi Biasa, lalu Berdiri
            if (getJumlahPenumpangPrioritas() < MAX_KURSI_PRIORITAS) {
                penumpangPrioritas.add(penumpang);
                System.out.println("Penumpang Prioritas (ID: " + penumpang.getID() + ") berhasil duduk di KURSI PRIORITAS.");
            } else if (getJumlahPenumpangBiasa() < MAX_KURSI_BIASA) {
                // Penumpang prioritas boleh duduk di kursi biasa [cite: 14]
                penumpangBiasa.add(penumpang);
                System.out.println("Penumpang Prioritas (ID: " + penumpang.getID() + ") berhasil duduk di KURSI BIASA.");
            } else {
                penumpangBerdiri.add(penumpang);
                System.out.println("Penumpang Prioritas (ID: " + penumpang.getID() + ") berhasil NAIK dan BERDIRI.");
            }
        } else {
            // Penumpang Biasa: coba masuk ke Kursi Biasa, lalu Berdiri
            if (getJumlahPenumpangBiasa() < MAX_KURSI_BIASA) {
                // Penumpang biasa akan duduk di kursi jika masih tersedia [cite: 12]
                penumpangBiasa.add(penumpang);
                System.out.println("Penumpang Biasa (ID: " + penumpang.getID() + ") berhasil duduk di KURSI BIASA.");
            } else {
                // Jika kursi sudah penuh, maka penumpang harus berdiri [cite: 13]
                penumpangBerdiri.add(penumpang);
                System.out.println("Penumpang Biasa (ID: " + penumpang.getID() + ") berhasil NAIK dan BERDIRI.");
            }
            // Penumpang biasa dilarang duduk di kursi prioritas [cite: 12] (sudah dijamin karena logicnya hanya mencoba kursi biasa)
        }

        // Bila penumpang berhasil naik, maka total pendapatan bus akan ditambah sejumlah ongkos [cite: 59]
        this.totalPendapatan += ONGKOS_BUS;
        return true; // Mengembalikan true jika penumpang berhasil naik [cite: 57]
    }

    /**
     * Method untuk menurunkan penumpang.
     * @param idPenumpang ID penumpang yang akan turun.
     * @return true jika penumpang ditemukan dan berhasil dihapus, false jika tidak.
     */
    public boolean turunkanPenumpang(int idPenumpang) {
        // Cari di kursi Prioritas
        if (penumpangPrioritas.removeIf(p -> p.getID() == idPenumpang)) {
            System.out.println("Penumpang (ID: " + idPenumpang + ") berhasil turun dari KURSI PRIORITAS.");
            return true;
        }

        // Cari di kursi Biasa
        if (penumpangBiasa.removeIf(p -> p.getID() == idPenumpang)) {
            System.out.println("Penumpang (ID: " + idPenumpang + ") berhasil turun dari KURSI BIASA.");
            return true;
        }

        // Cari di Penumpang Berdiri
        if (penumpangBerdiri.removeIf(p -> p.getID() == idPenumpang)) {
            System.out.println("Penumpang (ID: " + idPenumpang + ") berhasil turun dari POSISI BERDIRI.");
            return true;
        }
        
        // Jika tidak ditemukan [cite: 62]
        System.out.println("Gagal: Penumpang dengan ID " + idPenumpang + " tidak ditemukan.");
        return false;
    }

    /**
     * Method untuk mencetak daftar penumpang dan total informasi.
     * @return String representasi daftar penumpang dan total informasi bus.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // Penumpang Biasa [cite: 63]
        sb.append("Kursi Biasa (").append(getJumlahPenumpangBiasa()).append("/").append(MAX_KURSI_BIASA).append("):\n");
        if (penumpangBiasa.isEmpty()) {
            sb.append("  <kosong>\n");
        } else {
            for (Penumpang p : penumpangBiasa) {
                sb.append("  - ID: ").append(p.getID()).append(" (Umur: ").append(p.getUmur()).append(", Hamil: ").append(p.getHamil() ? "Ya" : "Tidak").append(", Prioritas: ").append(p.isPrioritas() ? "Ya" : "Tidak").append(")\n");
            }
        }
        
        // Penumpang Prioritas [cite: 63]
        sb.append("Kursi Prioritas (").append(getJumlahPenumpangPrioritas()).append("/").append(MAX_KURSI_PRIORITAS).append("):\n");
        if (penumpangPrioritas.isEmpty()) {
            sb.append("  <kosong>\n");
        } else {
            for (Penumpang p : penumpangPrioritas) {
                sb.append("  - ID: ").append(p.getID()).append(" (Umur: ").append(p.getUmur()).append(", Hamil: ").append(p.getHamil() ? "Ya" : "Tidak").append(")\n");
            }
        }
        
        // Penumpang Berdiri [cite: 63]
        sb.append("Posisi Berdiri (").append(getJumlahPenumpangBerdiri()).append("/").append(MAX_PENUMPANG_BERDIRI).append("):\n");
        if (penumpangBerdiri.isEmpty()) {
            sb.append("  <kosong>\n");
        } else {
            for (Penumpang p : penumpangBerdiri) {
                sb.append("  - ID: ").append(p.getID()).append(" (Umur: ").append(p.getUmur()).append(", Hamil: ").append(p.getHamil() ? "Ya" : "Tidak").append(", Prioritas: ").append(p.isPrioritas() ? "Ya" : "Tidak").append(")\n");
            }
        }
        
        // Jumlah semua penumpang [cite: 63]
        sb.append("\n==================================\n");
        sb.append("Jumlah Total Penumpang: ").append(getTotalPenumpang()).append(" / ").append(MAX_KAPASITAS_BUS).append("\n");
        // Total pendapatan bus [cite: 63]
        sb.append("Total Pendapatan Bus: ").append(getTotalPendapatan()).append(" (Ongkos per Penumpang: ").append(ONGKOS_BUS).append(")");
        
        return sb.toString();
    }
}