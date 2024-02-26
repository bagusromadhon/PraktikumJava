import java.util.Scanner;
import java.util.HashMap;

public class Main {
    private static final HashMap<String, String> ADMIN_DATA = new HashMap<>();

    public static void main(String[] args) {
        ADMIN_DATA.put("admin1", "admin123");
        ADMIN_DATA.put("admin2", "password123");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Library Login System");

        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("Silakan pilih jenis user:");
            System.out.println("1. Login as student");
            System.out.println("2. Login as admin");
            System.out.println("3. Exit");
            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    loggedIn = mahasiswaLogin(scanner);
                    break;
                case 2:
                    loggedIn = adminLogin(scanner);
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan Library Login System. Sampai jumpa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }

        System.out.println("Login berhasil. Selamat datang!");
        // Program berlanjut di sini setelah login berhasil
    }

    private static boolean adminLogin(Scanner scanner) {
        System.out.println("Masukkan username admin:");
        String username = scanner.nextLine();
        System.out.println("Masukkan password admin:");
        String password = scanner.nextLine();

        if (ADMIN_DATA.containsKey(username) && ADMIN_DATA.get(username).equals(password)) {
            System.out.println("Login admin berhasil!");
            return true;
        } else {
            System.out.println("Username atau password admin salah. Silakan coba lagi.");
            return false;
        }
    }

    private static boolean mahasiswaLogin(Scanner scanner) {
        System.out.println("Masukkan NIM (Nomor Induk Mahasiswa):");
        String nim = scanner.nextLine();

        if (nim.length() <= 15) {
            System.out.println("Login mahasiswa berhasil!");
            return true;
        } else {
            System.out.println("Panjang NIM harus sama dengan 15. Silakan coba lagi.");
            return false;
        }
    }
}
