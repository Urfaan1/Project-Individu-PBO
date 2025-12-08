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
