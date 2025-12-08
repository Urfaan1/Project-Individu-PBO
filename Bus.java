import java.util.ArrayList; 
import java.util.List;

public class Bus {
   
    static final int ONGKOS_BUS = 2000; 
    
    private static final int MAX_KURSI_BIASA = 16; 
    private static final int MAX_KURSI_PRIORITAS = 4; 
    private static final int MAX_PENUMPANG_BERDIRI = 20; 
    private static final int MAX_KAPASITAS_BUS = MAX_KURSI_BIASA + MAX_KURSI_PRIORITAS + MAX_PENUMPANG_BERDIRI; 

    private List<Penumpang> penumpangBiasa; 
    private List<Penumpang> penumpangPrioritas; 
    private List<Penumpang> penumpangBerdiri; 
    private int totalPendapatan; 

   public List<Penumpang> getPenumpangBiasa() {
        return penumpangBiasa;
    }

    public List<Penumpang> getPenumpangPrioritas() {
        return penumpangPrioritas;
    }

    public List<Penumpang> getPenumpangBerdiri() {
        return penumpangBerdiri;
    }

    public int getJumlahPenumpangBiasa() {
        return penumpangBiasa.size();
    }

    public int getJumlahPenumpangPrioritas() {
        return penumpangPrioritas.size();
    }

    public int getJumlahPenumpangBerdiri() {
        return penumpangBerdiri.size();
    }

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
        if (getTotalPenumpang() >= MAX_KAPASITAS_BUS) {
            System.out.println("Gagal: Bus sudah penuh (Kapasitas Maksimal: " + MAX_KAPASITAS_BUS + ").");
            return false; 
        }

        if (!penumpang.kurangiSaldo(ONGKOS_BUS)) {
            System.out.println("Gagal: Saldo tidak mencukupi untuk membayar ongkos bus (" + ONGKOS_BUS + "). Saldo saat ini: " + penumpang.getSaldo());
            return false;
        }

        if (penumpang.isPrioritas()) {
   
            if (getJumlahPenumpangPrioritas() < MAX_KURSI_PRIORITAS) {
                penumpangPrioritas.add(penumpang);
                System.out.println("Penumpang Prioritas (ID: " + penumpang.getID() + ") berhasil duduk di KURSI PRIORITAS.");
            } else if (getJumlahPenumpangBiasa() < MAX_KURSI_BIASA) {
                penumpangBiasa.add(penumpang);
                System.out.println("Penumpang Prioritas (ID: " + penumpang.getID() + ") berhasil duduk di KURSI BIASA.");
            } else {
                penumpangBerdiri.add(penumpang);
                System.out.println("Penumpang Prioritas (ID: " + penumpang.getID() + ") berhasil NAIK dan BERDIRI.");
            }
        } else {
            if (getJumlahPenumpangBiasa() < MAX_KURSI_BIASA) {
                penumpangBiasa.add(penumpang);
                System.out.println("Penumpang Biasa (ID: " + penumpang.getID() + ") berhasil duduk di KURSI BIASA.");
            } else {
                penumpangBerdiri.add(penumpang);
                System.out.println("Penumpang Biasa (ID: " + penumpang.getID() + ") berhasil NAIK dan BERDIRI.");
            }
        }
        this.totalPendapatan += ONGKOS_BUS;
        return true; 
    }
   /**
     * Method untuk menurunkan penumpang.
     * @param idPenumpang ID penumpang yang akan turun.
     * @return true jika penumpang ditemukan dan berhasil dihapus, false jika tidak.
     */
    public boolean turunkanPenumpang(int idPenumpang) {
        if (penumpangPrioritas.removeIf(p -> p.getID() == idPenumpang)) {
            System.out.println("Penumpang (ID: " + idPenumpang + ") berhasil turun dari KURSI PRIORITAS.");
            return true;
        }
        if (penumpangBiasa.removeIf(p -> p.getID() == idPenumpang)) {
            System.out.println("Penumpang (ID: " + idPenumpang + ") berhasil turun dari KURSI BIASA.");
            return true;
        }
        if (penumpangBerdiri.removeIf(p -> p.getID() == idPenumpang)) {
            System.out.println("Penumpang (ID: " + idPenumpang + ") berhasil turun dari POSISI BERDIRI.");
            return true;
        }
        System.out.println("Gagal: Penumpang dengan ID " + idPenumpang + " tidak ditemukan.");
        return false;
    }
