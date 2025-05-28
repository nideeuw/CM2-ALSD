public class QueueTransaksi {
    TransaksiLayanan[] data;
    int front, rear, size, max;

    public QueueTransaksi(int kapasitas) {
        max = kapasitas;
        data = new TransaksiLayanan[max];
        size = 0;
        front = rear = -1;
    }
     public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void tambahTransaksi(TransaksiLayanan t) {
        if (isFull()) {
            System.out.println("Queue transaksi penuh.");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % max;
            }
            data[rear] = t;
            size++;
        }
    }

    public void tampilkanTransaksi() {
        if (isEmpty()) {
            System.out.println("Tidak ada transaksi layanan.");
        } else {
            System.out.println("-- Riwayat Transaksi --");
            System.out.println("Daftar Transaksi:");
            int idx = front;
            for (int i = 0; i < size; i++) {
                data[idx].tampilkanTransaksi();
                idx = (idx + 1) % max;
            }
        }
    }
}
