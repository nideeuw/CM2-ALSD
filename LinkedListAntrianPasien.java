public class AntrianPasien {
    NodePasien head, tail;

    public boolean isEmpty() {
        return head == null;
    }
    public void tambahAntrian(Pasien p) {
        NodePasien baru = new NodePasien(p, null);
        if (isEmpty()) {
            head = tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
        System.out.println(">> Pasien masuk ke dalam antrian.");
    }

    public Pasien layaniPasien() {
        if (isEmpty()) {
            System.out.println(">> Tidak ada pasien dalam antrian.");
            return null;
        } else {
            Pasien p = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return p;
        }
    }
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println(">> Tidak ada pasien dalam antrian.");
        } else {
            System.out.println("-- Antrian Pasien --");
            System.out.println("Antrian Pasien:");
            NodePasien temp = head;
            while (temp != null) {
                temp.data.tampilkanInformasi();
                temp = temp.next;
            }
        }
    }
    public int hitungSisaAntrian() {
        int count = 0;
        NodePasien temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
