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
