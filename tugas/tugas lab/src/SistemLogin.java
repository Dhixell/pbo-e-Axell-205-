import java.util.Scanner;

public class SistemLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            // Menampilkan pilihan login
            System.out.println("Pilih jenis login:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.print("Masukkan pilihan Anda: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Pilihan tidak valid. Silakan masukkan angka 1 atau 2.");
                scanner.next(); // Membersihkan input yang salah
            }
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi newline

            if (pilihan != 1 && pilihan != 2) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.\n");
            }
        } while (pilihan != 1 && pilihan != 2);

        if (pilihan == 1) { // Login Admin
            String username, password;
            do {
                System.out.print("Masukkan Username: ");
                username = scanner.nextLine().trim();
                System.out.print("Masukkan Password: ");
                password = scanner.nextLine().trim();

                if (!username.startsWith("admin") || !password.startsWith("password")) {
                    System.out.println("Login gagal! Username atau password salah. Coba lagi.\n");
                }
            } while (!username.startsWith("admin") || !password.startsWith("password"));

            System.out.println("Login admin berhasil!");
        } else { // Login Mahasiswa
            String nama, nim;
            do {
                System.out.print("Masukkan Nama: ");
                nama = scanner.nextLine().trim();
                System.out.print("Masukkan NIM: ");
                nim = scanner.nextLine().trim();

                if (nama.isEmpty() || nim.isEmpty()) {
                    System.out.println("Login gagal! Nama atau NIM tidak boleh kosong. Coba lagi.\n");
                }
            } while (nama.isEmpty() || nim.isEmpty());

            System.out.println("Login Mahasiswa berhasil!");
            System.out.println("Nama: " + nama);
            System.out.println("NIM: " + nim);
        }

        scanner.close();
    }
}
