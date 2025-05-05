package app;
import perpustakaan.*;
public class Main {
    public static void main(String[] args) {
        perpustakaan.Buku nonFiksi = new NonFiksi("Filosofi Teras", "Henry Manampiring");
        Buku fiksi = new Fiksi("laskar Pelangi", "Andrea Hirata");

        Anggota anggota1 = new Anggota("Axell Dhias Ramadhani", "E205");
        Anggota anggota2 = new Anggota("Habibi Dzakki Putra", "E180");

        nonFiksi.displayInfo();
        fiksi.displayInfo();

        System.out.println();

        anggota1.display();
        anggota2.display();

        System.out.println();

        anggota1.pinjamBuku("Laskar Pelangi", 7);
        anggota2.pinjamBuku("Filosofi Teras", 7);

        System.out.println();

        anggota1.kembalikanBuku("Laskar Pelangi");
        anggota2.kembalikanBuku("Filosofi Teras");
    }
}
