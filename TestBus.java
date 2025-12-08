import java.util.Scanner;

public class TestBus {
    public static void main(String[] args) {
        // Instansiasi Object
        Bus transKoetaradja = new Bus(); // Object Bus

        // Inisialisasi Scanner untuk Input
        Scanner scanner = new Scanner(System.in);
        
        int pilihan;
        int nextId = 1; // Untuk memberikan ID unik otomatis

        System.out.println("===== SIMULASI BUS TRANS KOETARADJA =====");

        do {
            // Tampilkan Menu [cite: 67, 77, 89, 96, 107, 114]
            System.out.println("\n--- MENU ---");
            System.out.println("1. Naikkan Penumpang"); // [cite: 69]
            System.out.println("2. Turunkan Penumpang (Berdasarkan ID)"); // [cite: 70]
            System.out.println("3. Lihat Penumpang & Informasi Bus"); // [cite: 71]
            System.out.println("4. Tambah Saldo Penumpang");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: "); // [cite: 72]
            
            // Exception Handling untuk input non-integer
            try {
                pilihan = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
                scanner.nextLine(); // Membersihkan buffer input
                pilihan = -1; // Set pilihan ke nilai yang tidak ada di menu
                continue;
            }
            scanner.nextLine(); // Membersihkan buffer setelah nextInt()
switch (pilihan) {
                case 1: // Naikkan Penumpang
                    System.out.println("\n--- NAIKKAN PENUMPANG ---");
                    
                    // Input Data Penumpang Baru
                    // Menggunakan ID sebagai pengganti Nama berdasarkan contoh simulasi [cite: 82]
                    System.out.println("ID Penumpang (digunakan untuk turun): " + nextId + " (Otomatis)");
                    int idBaru = nextId; 
                    
                    System.out.print("Umur: "); // [cite: 83]
                    int umurBaru = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Hamil (y/n): "); // [cite: 84]
                    String hamilInput = scanner.nextLine().toLowerCase();
                    boolean hamilBaru = hamilInput.equals("y");

                    // Instansiasi objek baru (Pemanggilan Method Constructor)
                    Penumpang penumpangBaru = new Penumpang(idBaru, umurBaru, hamilBaru); // Objek Penumpang
                    
                    // Simulasi Tambah Saldo
                    if (penumpangBaru.getSaldo() < Bus.ONGKOS_BUS) {
                        System.out.println("Saldo awal kurang dari ongkos. Tambahkan saldo otomatis.");
                        penumpangBaru.tambahSaldo(Bus.ONGKOS_BUS); // Memanggil method tambahSaldo
                    }
                    
                    // Naikkan Penumpang (Pemanggilan Method)
                    if (transKoetaradja.naikkanPenumpang(penumpangBaru)) {
                        System.out.println("Penumpang berhasil ditambahkan!"); // [cite: 87]
                        nextId++; // Increment ID untuk penumpang berikutnya
                    }
                    break;
        case 2: // Turunkan Penumpang
                    System.out.println("\n--- TURUNKAN PENUMPANG ---");
                    System.out.print("Masukkan ID Penumpang yang akan turun: "); // [cite: 101]
                    int idTurun;
                    try {
                        idTurun = scanner.nextInt();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Input ID tidak valid. Harus berupa angka.");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine(); 

                    // Turunkan Penumpang
                    if (transKoetaradja.turunkanPenumpang(idTurun)) { // Memanggil method
                        System.out.println("Penumpang Berhasil Turun!"); // [cite: 103]
                    } else {
                        System.out.println("Penumpang Tidak ditemukan!"); // [cite: 122]
                    }
                    break;
