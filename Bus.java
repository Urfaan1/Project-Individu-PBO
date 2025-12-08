import java.util.ArrayList; 
import java.util.List;

public class Bus {
   
    static final int ONGKOS_BUS = 2000; // Ongkos naik bus per penumpang
    // Kapasitas masing-masing jenis tempat
    private static final int MAX_KURSI_BIASA = 16; 
    private static final int MAX_KURSI_PRIORITAS = 4; 
    private static final int MAX_PENUMPANG_BERDIRI = 20; 
    private static final int MAX_KAPASITAS_BUS = MAX_KURSI_BIASA + MAX_KURSI_PRIORITAS + MAX_PENUMPANG_BERDIRI; 
   // List penumpang berdasarkan posisi
    private List<Penumpang> penumpangBiasa; 
    private List<Penumpang> penumpangPrioritas; 
    private List<Penumpang> penumpangBerdiri; 
   // Total uang yang masuk
    private int totalPendapatan; 
    // Getter list penumpang
   public List<Penumpang> getPenumpangBiasa() {
        return penumpangBiasa;
    }
    public List<Penumpang> getPenumpangPrioritas() {
        return penumpangPrioritas;
    }
    public List<Penumpang> getPenumpangBerdiri() {
        return penumpangBerdiri;
    }

   // Getter jumlah penumpang
    public int getJumlahPenumpangBiasa() {
        return penumpangBiasa.size();
    }
    public int getJumlahPenumpangPrioritas() {
        return penumpangPrioritas.size();
    }
    public int getJumlahPenumpangBerdiri() {
        return penumpangBerdiri.size();
    }

   // Total keseluruhan penumpang
    public int getTotalPenumpang() {
        return getJumlahPenumpangBiasa() + getJumlahPenumpangPrioritas() + getJumlahPenumpangBerdiri();
    }

    public int getTotalPendapatan() {
        return totalPendapatan;

       /**
     * Method untuk menambahkan penumpang ke dalam Bus (selagi bus belum melebihi kapasitas).
     * @param penumpang Objek Penumpang yang akan naik.
     * @return true jika penumpang berhasil naik, false jika tidak.
     */

public boolean naikkanPenumpang(Penumpang penumpang) {
    // Cek kapasitas bus
        if (getTotalPenumpang() >= MAX_KAPASITAS_BUS) {
            System.out.println("Gagal: Bus sudah penuh (Kapasitas Maksimal: " + MAX_KAPASITAS_BUS + ").");
            return false; 
        }
   // Cek saldo penumpang
        if (!penumpang.kurangiSaldo(ONGKOS_BUS)) {
            System.out.println("Gagal: Saldo tidak mencukupi untuk membayar ongkos bus (" + ONGKOS_BUS + "). Saldo saat ini: " + penumpang.getSaldo());
            return false;
        }
   // Aturan untuk penumpang prioritas
        if (penumpang.isPrioritas()) {
            // Duduk di kursi prioritas dulu
            if (getJumlahPenumpangPrioritas() < MAX_KURSI_PRIORITAS) {
                penumpangPrioritas.add(penumpang);
                System.out.println("Penumpang Prioritas (ID: " + penumpang.getID() + ") berhasil duduk di KURSI PRIORITAS.");
            // Jika penuh, pindah ke kursi biasa
            } else if (getJumlahPenumpangBiasa() < MAX_KURSI_BIASA) {
                penumpangBiasa.add(penumpang);
                System.out.println("Penumpang Prioritas (ID: " + penumpang.getID() + ") berhasil duduk di KURSI BIASA.");
            // Jika penuh juga, berdiri
            } else {
                penumpangBerdiri.add(penumpang);
                System.out.println("Penumpang Prioritas (ID: " + penumpang.getID() + ") berhasil NAIK dan BERDIRI.");
            }
        } else {
           // Penumpang biasa → duduk di kursi biasa dulu
            if (getJumlahPenumpangBiasa() < MAX_KURSI_BIASA) {
                penumpangBiasa.add(penumpang);
                System.out.println("Penumpang Biasa (ID: " + penumpang.getID() + ") berhasil duduk di KURSI BIASA.");
            } else {
               // Jika penuh → berdiri
                penumpangBerdiri.add(penumpang);
                System.out.println("Penumpang Biasa (ID: " + penumpang.getID() + ") berhasil NAIK dan BERDIRI.");
            }
        }
        this.totalPendapatan += ONGKOS_BUS;// Tambah pendapatan
        return true; 
    }
   /**
     * Method untuk menurunkan penumpang.
     * @param idPenumpang ID penumpang yang akan turun.
     * @return true jika penumpang ditemukan dan berhasil dihapus, false jika tidak.
     */
    public boolean turunkanPenumpang(int idPenumpang) {
       // Cek di kursi prioritas
        if (penumpangPrioritas.removeIf(p -> p.getID() == idPenumpang)) {
            System.out.println("Penumpang (ID: " + idPenumpang + ") berhasil turun dari KURSI PRIORITAS.");
            return true;
        }
       // Cek di kursi biasa
        if (penumpangBiasa.removeIf(p -> p.getID() == idPenumpang)) {
            System.out.println("Penumpang (ID: " + idPenumpang + ") berhasil turun dari KURSI BIASA.");
            return true;
        }
       // Cek di posisi berdiri
        if (penumpangBerdiri.removeIf(p -> p.getID() == idPenumpang)) {
            System.out.println("Penumpang (ID: " + idPenumpang + ") berhasil turun dari POSISI BERDIRI.");
            return true;
        }
       // Jika tidak ditemukan
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

       // Tampilkan kursi biasa
        sb.append("Kursi Biasa (").append(getJumlahPenumpangBiasa()).append("/").append(MAX_KURSI_BIASA).append("):\n");
        if (penumpangBiasa.isEmpty()) {
            sb.append("  <kosong>\n");
        } else {
            for (Penumpang p : penumpangBiasa) {
                sb.append("  - ID: ").append(p.getID()).append(" (Umur: ").append(p.getUmur()).append(", Hamil: ").append(p.getHamil() ? "Ya" : "Tidak").append(", Prioritas: ").append(p.isPrioritas() ? "Ya" : "Tidak").append(")\n");
            }
        }
         // Tampilkan kursi prioritas
        sb.append("Kursi Prioritas (").append(getJumlahPenumpangPrioritas()).append("/").append(MAX_KURSI_PRIORITAS).append("):\n");
        if (penumpangPrioritas.isEmpty()) {
            sb.append("  <kosong>\n");
        } else {
            for (Penumpang p : penumpangPrioritas) {
                sb.append("  - ID: ").append(p.getID()).append(" (Umur: ").append(p.getUmur()).append(", Hamil: ").append(p.getHamil() ? "Ya" : "Tidak").append(")\n");
            }
        }
         // Tampilkan posisi berdiri
        sb.append("Posisi Berdiri (").append(getJumlahPenumpangBerdiri()).append("/").append(MAX_PENUMPANG_BERDIRI).append("):\n");
        if (penumpangBerdiri.isEmpty()) {
            sb.append("  <kosong>\n");
        } else {
            for (Penumpang p : penumpangBerdiri) {
                sb.append("  - ID: ").append(p.getID()).append(" (Umur: ").append(p.getUmur()).append(", Hamil: ").append(p.getHamil() ? "Ya" : "Tidak").append(", Prioritas: ").append(p.isPrioritas() ? "Ya" : "Tidak").append(")\n");
            }
        }
        // Total keseluruhan
        sb.append("\n==================================\n");
        sb.append("Jumlah Total Penumpang: ").append(getTotalPenumpang()).append(" / ").append(MAX_KAPASITAS_BUS).append("\n");
        sb.append("Total Pendapatan Bus: ").append(getTotalPendapatan()).append(" (Ongkos per Penumpang: ").append(ONGKOS_BUS).append(")");
        
        return sb.toString();
    }
}
