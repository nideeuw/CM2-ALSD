public class TransaksiLayanan {
    Pasien pasien;
    Dokter dokter;
    int durasiLayanan, biaya;

    public TransaksiLayanan(Pasien pasien, Dokter dokter, int durasi) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.durasiLayanan = durasi;
        this.biaya = hitungBiaya();
    }

    public int hitungBiaya() {
        return durasiLayanan * 50000;
    }

    public void tampilkanTransaksi() {
        System.out.println(pasien.nama + " (" + durasiLayanan + " jam): Rp " + biaya);
    }
}
