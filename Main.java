import java.util.Scanner;

// Superclass
class Barang {
    // Atribut private untuk menyimpan kode barang, nama barang, dan harga barang
    private String kodeBarang;
    private String namaBarang;
    private double hargaBarang;

    // Constructor untuk menginisialisasi atribut Barang
    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    // Getter untuk kode barang
    public String getKodeBarang() {
        return kodeBarang;
    }

    // Getter untuk nama barang
    public String getNamaBarang() {
        return namaBarang;
    }

    // Getter untuk harga barang
    public double getHargaBarang() {
        return hargaBarang;
    }
}

// Subclass
class Transaksi extends Barang { // Inheritance: Transaksi mewarisi Barang
    private int jumlahBeli;

    // Constructor untuk Transaksi, memanggil constructor Barang menggunakan super()
    public Transaksi(String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang); // Memanggil constructor dari superclass
        this.jumlahBeli = jumlahBeli;
    }

    // Metode untuk menghitung total harga
    public double hitungTotal() {
        return getHargaBarang() * jumlahBeli; // Menggunakan metode dari superclass
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Meminta input dari pengguna untuk setiap atribut transaksi
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = Double.parseDouble(scanner.nextLine()); // Konversi input string ke double

            // Validasi harga barang harus lebih dari 0
            if (hargaBarang <= 0) {
                throw new IllegalArgumentException("Harga barang harus lebih dari 0!"); // Exception handling
            }

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = Integer.parseInt(scanner.nextLine()); // Konversi input string ke integer

            // Validasi jumlah beli harus lebih dari 0
            if (jumlahBeli <= 0) {
                throw new IllegalArgumentException("Jumlah beli harus lebih dari 0!"); // Exception handling
            }

            // Membuat objek Transaksi
            Transaksi transaksi = new Transaksi(kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Menampilkan hasil transaksi
            System.out.println("\n--- Detail Transaksi ---");
            System.out.println("No Faktur: " + noFaktur);
            System.out.println("Kode Barang: " + transaksi.getKodeBarang());
            System.out.println("Nama Barang: " + transaksi.getNamaBarang());
            System.out.println("Harga Barang: Rp" + transaksi.getHargaBarang());
            System.out.println("Jumlah Beli: " + jumlahBeli);
            System.out.println("Total: Rp" + transaksi.hitungTotal());
        } catch (NumberFormatException e) {
            // Menangkap error jika input harga atau jumlah beli bukan angka
            System.out.println("Error: Input harus berupa angka untuk harga barang atau jumlah beli!");
        } catch (IllegalArgumentException e) {
            // Menangkap error jika input tidak valid sesuai dengan aturan (contoh: harga <= 0)
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Menangkap error yang tidak terduga
            System.out.println("Error: Terjadi kesalahan yang tidak diketahui.");
        } finally {
            // Menutup scanner untuk menghindari kebocoran sumber daya
            scanner.close();
        }
    }
}