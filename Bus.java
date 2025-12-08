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
