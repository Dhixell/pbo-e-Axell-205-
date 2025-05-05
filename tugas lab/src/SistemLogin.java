import java.util.Scanner;

public class SistemLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        admin admin = new admin("Admin", "202410370110205");
        mahasiswa mahasiswa = new mahasiswa("Axell Dhias Ramadhani", "202410370110205");
        while (true) {
            System.out.println("\n=== Sistem Login ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan (1/2/3): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan line
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String password = scanner.nextLine();

                    if (admin.login(username, password)) {
                        admin.displayInfo();
                    } else {
                        System.out.println("Login Admin gagal! Username atau password salah.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();

                    if (mahasiswa.login(nama, nim)) {
                        mahasiswa.displayInfo();
                    } else {
                        System.out.println("Login Mahasiswa gagal! Nama atau NIM salah.");
                    }
                    break;

                case 3:
                    System.out.println("Terima kasih! Program selesai.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
