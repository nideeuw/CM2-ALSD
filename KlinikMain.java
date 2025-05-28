import java.util.Scanner;

public class KlinikMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianPasien antrian = new AntrianPasien();
        QueueTransaksi transaksiQueue = new QueueTransaksi(100);

        int pilih;
        do {
            System.out.println("=== SISTEM ANTRIAN KLINIK ===");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Antrian Pasien");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.println(">> Sisa pasien dalam antrian: " + antrian.hitungSisaAntrian());
                    break;

                case 5:
                    transaksiQueue.tampilkanTransaksi();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println();
        } while (pilih != 0);
    }
}