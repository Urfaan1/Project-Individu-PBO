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
