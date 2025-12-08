# 🚌 Proyek Individu: Sistem Pengelolaan Penumpang Bus Trans Koetaradja

Proyek ini adalah implementasi program sederhana berbasis Java untuk mensimulasikan dan mengelola penumpang pada Bus Trans Koetaradja di Banda Aceh. Tujuannya adalah menerapkan konsep-konsep Pemrograman Berorientasi Objek (OOP) dalam konteks manajemen entitas nyata (Bus dan Penumpang) sesuai dengan aturan dan batasan yang telah diobservasi.

---

## 📋 Aturan dan Batasan Bus

Program ini didasarkan pada observasi Bus Trans Koetaradja, dengan batasan utama sebagai berikut:

### 1. Kapasitas
* [cite_start]**Total Kursi:** 20 kursi (16 Biasa, 4 Prioritas)[cite: 6].
* [cite_start]**Kapasitas Maksimal:** 40 orang[cite: 7].
* [cite_start]Penumpang yang tidak mendapatkan kursi akan **berdiri**[cite: 7].

### 2. Kursi Prioritas
[cite_start]Kursi prioritas hanya dapat diisi oleh penumpang yang termasuk kategori prioritas[cite: 8]:
* [cite_start]Lansia (umur > 60 tahun)[cite: 9].
* [cite_start]Anak-anak (umur < 10 tahun)[cite: 10].
* [cite_start]Ibu hamil[cite: 11].

### 3. Aturan Penempatan
* [cite_start]**Penumpang Prioritas:** Boleh duduk di kursi Prioritas, Kursi Biasa, atau Berdiri[cite: 14].
* **Penumpang Biasa:** Hanya boleh duduk di Kursi Biasa atau Berdiri. [cite_start]**Dilarang** duduk di kursi Prioritas[cite: 12].

### 4. Transaksi
* [cite_start]Setiap penumpang harus memiliki saldo yang mencukupi untuk membayar ongkos[cite: 58].
* [cite_start]**Ongkos Bus:** 2000 per penumpang (bersifat `static` dan `final`)[cite: 48].
* [cite_start]**Saldo Awal Penumpang:** 10.000[cite: 41].

---

## 🛠️ Struktur Program (Class Diagram)

Program ini diimplementasikan menggunakan tiga *class* utama: `Penumpang`, `Bus`, dan `TestBus`.

### 1. Class `Penumpang.java`
[cite_start]Mewakili entitas penumpang (kartu penumpang)[cite: 38, 39].

| Atribut | Deskripsi |
| :--- | :--- |
| `id: int` | ID unik penumpang. |
| `umur: int` | Umur penumpang. |
| `hamil: Boolean` | Status hamil penumpang. |
| `saldo: int` | [cite_start]Saldo kartu penumpang (Awal: 10.000)[cite: 41]. |

| Method Penting | Fungsi |
| :--- | :--- |
| `Penumpang(id, umur, hamil)` | Constructor. |
| `tambahSaldo(int)` | [cite_start]Menambahkan saldo[cite: 43]. |
| `kurangiSaldo(int)` | [cite_start]Mengurangi saldo saat membayar ongkos[cite: 44]. |
| `isPrioritas()` | Mengecek status prioritas (Lansia/Anak/Hamil). |

### 2. Class `Bus.java`
Mewakili bus Trans Koetaradja.

| Atribut | Deskripsi |
| :--- | :--- |
| `penumpangBiasa: List<Penumpang>` | [cite_start]Koleksi penumpang duduk di kursi biasa (Maks. 16)[cite: 21]. |
| `penumpangPrioritas: List<Penumpang>` | [cite_start]Koleksi penumpang duduk di kursi prioritas (Maks. 4)[cite: 22]. |
| `penumpangBerdiri: List<Penumpang>` | [cite_start]Koleksi penumpang yang berdiri (Maks. 20)[cite: 23]. |
| `ONGKOS_BUS: static final int` | [cite_start]Nilai ongkos (2000)[cite: 48]. |
| `totalPendapatan: int` | [cite_start]Total pendapatan bus dari ongkos[cite: 49]. |

| Method Penting | Fungsi |
| :--- | :--- |
| `naikkanPenumpang(Penumpang)` | [cite_start]Menambahkan penumpang dengan mempertimbangkan kapasitas, saldo, dan aturan penempatan[cite: 56, 58, 60]. |
| `turunkanPenumpang(int)` | [cite_start]Menghapus penumpang berdasarkan ID[cite: 61]. |
| `toString()` | [cite_start]Mencetak daftar penumpang, jumlah total, dan total pendapatan bus[cite: 63]. |

### 3. Class `TestBus.java`
[cite_start]Berisi method `main()` untuk mensimulasikan operasi bus secara interaktif melalui konsol[cite: 64]. Menyediakan menu untuk **Naikkan Penumpang**, **Turunkan Penumpang**, **Lihat Informasi Bus**, dan **Tambah Saldo**.

---

## 💡 Konsep Pemrograman Berorientasi Objek (OOP)

[cite_start]Minimal **6 konsep** OOP telah diterapkan dalam proyek ini[cite: 125].

| Konsep OOP | Implementasi |
| :--- | :--- |
| **1. Class dan Objek** | Implementasi `Class Penumpang` dan `Class Bus` serta instansiasi objek-objek tersebut di `TestBus.java`. |
| **2. Encapsulation** | Penggunaan *private fields* (`id`, `saldo`, `penumpangBiasa`, dll.) yang hanya dapat diakses melalui *public getter* dan *setter* (mutator method). Contoh: `getSaldo()`. |
| **3. Method** | Semua fungsi program diimplementasikan melalui *method* dalam *class* yang relevan, seperti `naikkanPenumpang()` dan `kurangiSaldo()`. |
| **4. Koleksi Data** | [cite_start]Penggunaan `java.util.ArrayList` di `Class Bus` untuk mengelola data kumpulan objek `Penumpang` (penumpang duduk dan berdiri)[cite: 54]. |
| **5. Konstanta (`static final`)** | [cite_start]Penggunaan `static final int ONGKOS_BUS` di *Class* `Bus` untuk nilai yang tidak berubah dan dibagikan ke semua instansi bus[cite: 48]. |
| **6. Exception Handling** | Penggunaan blok `try-catch` di `TestBus.java` untuk mencegah program *crash* akibat `InputMismatchException` saat pengguna salah memasukkan tipe data pada input menu atau ID. |

---

## 🏃 Cara Menjalankan Program

1.  Pastikan Anda memiliki *project* BlueJ yang berisi ketiga file: `Penumpang.java`, `Bus.java`, dan `TestBus.java`.
2.  Buka `TestBus.java` dan jalankan *method* `main()`.
3.  Ikuti petunjuk menu yang muncul di konsol.
