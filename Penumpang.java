public class Penumpang {
    private int id; 
    private int umur; 
    private boolean hamil; 
    private int saldo; 
    private static final int SALDO_AWAL = 10000; 
     /**
     * Constructor untuk Class Penumpang.
     * Saldo awal diatur ke SALDO_AWAL (10.000).
     * @param id ID unik penumpang
     * @param umur Umur penumpang
     * @param hamil Status hamil penumpang
     */
    public Penumpang(int id, int umur, boolean hamil) {
        this.id = id;
        this.umur = umur;
        this.hamil = hamil;
        this.saldo = SALDO_AWAL; 
    }
    public int getID() {
        return id;
    }
    public int getUmur() {
        return umur;
    }
    public boolean getHamil() {
        return hamil;
    }
    public int getSaldo() {
        return saldo;
    }
    /**
     * Menambah saldo kartu penumpang.
     * @param saldobaru Jumlah saldo yang ditambahkan
     */
    public void tambahSaldo(int saldobaru) {
        if (saldobaru > 0) {
            this.saldo += saldobaru; 
            System.out.println("Saldo berhasil ditambahkan. Saldo saat ini: " + this.saldo);
        } else {
            System.out.println("Gagal: Jumlah saldo baru harus positif.");
        }
    }

    /**
     * Mengurangi saldo kartu penumpang saat membayar ongkos bus.
     * @param ongkos Jumlah ongkos bus
     * @return true jika saldo mencukupi dan berhasil dikurangi, false jika tidak.
     */
    public boolean kurangiSaldo(int ongkos) {
        
        if (this.saldo >= ongkos) {
            this.saldo -= ongkos;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Mengecek apakah penumpang ini termasuk penumpang prioritas.
     * @return true jika lansia, anak-anak, atau ibu hamil.
     */
    public boolean isPrioritas() {
        return this.umur > 60 || this.umur < 10 || this.hamil;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " (Umur: " + this.umur + ", Hamil: " + (this.hamil ? "Ya" : "Tidak") + ")";
    }
}
