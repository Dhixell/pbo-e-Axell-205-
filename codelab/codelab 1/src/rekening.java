class bank {
    private final String nomorRekening;
    private final String namaPemilik;
    private double saldo;

    public bank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    public void setor(double jumlah) {
        saldo += jumlah;
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
    }

    public void tarik(double jumlah) {
        if (jumlah > saldo) {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldo);
        } else {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo);
        }
    }

    public void tampilkanRekening() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
        System.out.println();
    }

    public static void main(String[] args) {
        bank rekening1 = new bank("202410370110205", "Axell", 500000);
        bank rekening2 = new bank("202410370110222", "Azka", 1000000);

        rekening1.tampilkanRekening();
        rekening2.tampilkanRekening();

        rekening1.setor(200000);
        rekening2.setor(500000);

        rekening1.tarik(800000);
        rekening2.tarik(300000);

        rekening1.tampilkanRekening();
        rekening2.tampilkanRekening();
    }
}
