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
                    System.out.print("Nama Pasien: ");
                    String nama = sc.nextLine();
                    System.out.print("NIK: ");
                    String nik = sc.nextLine();
                    System.out.print("Keluhan: ");
                    String keluhan = sc.nextLine();
                    antrian.tambahAntrian(new Pasien(nama, nik, keluhan));
                    break;

                case 2:
                    antrian.tampilkanAntrian();
                    break;

                case 3:
                    if (antrian.isEmpty()) {
                        System.out.println(">> Tidak ada pasien dalam antrian.");
                    } else {
                        Pasien p = antrian.layaniPasien();
                        System.out.println("Pasien " + p.nama + " dipanggil");
                        System.out.print("Masukkan ID Dokter: ");
                        String id = sc.nextLine();
                        System.out.print("Masukkan Nama Dokter: ");
                        String namaDok = sc.nextLine();
                        System.out.print("Masukkan Durasi Layanan (jam): ");
                        int durasi = sc.nextInt();
                        sc.nextLine();
                        Dokter d = new Dokter(id, namaDok);
                        TransaksiLayanan t = new TransaksiLayanan(p, d, durasi);
                        transaksiQueue.tambahTransaksi(t);
                        System.out.println(">> Pasien telah dilayani, transaksi berhasil dicatat.");
                    }
                    break;

                case 4:
                    System.out.println(">> Sisa pasien dalam antrian: " + antrian.hitungSisaAntrian());
                    break;

                case 5:
                    transaksiQueue.tampilkanTransaksi();
                    break;

                case 0:
                    System.out.println("Terima kasih.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println();
        } while (pilih != 0);
    }
}