import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Admin extends User {
    private static final HashMap<String, String> ADMIN_DATA = new HashMap<>();

    static {
        ADMIN_DATA.put("admin", "admin");
    }



    public void displayStudents() {
        System.out.println("List of Registered Students:");
        for (Map.Entry<String, String[]> entry : Main.userStudent.entrySet()) {
            String nim = entry.getKey();
            String[] studentInfo = entry.getValue();
            System.out.println("Name: " + studentInfo[0]);
            System.out.println("Faculty: " + studentInfo[1]);
            System.out.println("NIM: " + nim);
            System.out.println("Program: " + studentInfo[2]);
            System.out.println();
        }
    }

    public boolean checkCredentials(String username, String password) {
        return ADMIN_DATA.containsKey(username) && ADMIN_DATA.get(username).equals(password);
    }

    public static void addStudent(Scanner scanner) {
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        String nim;
        do {
            System.out.print("Enter student NIM (15 digits): ");
            nim = scanner.nextLine();
            if (nim.length() != 15)
                System.out.println("NIM must be 15 digits.");
        } while (nim.length() != 15);

        System.out.print("Enter student faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter student program: ");
        String program = scanner.nextLine();

        Main.userStudent.put(nim, new String[]{name, faculty, program});
        System.out.println("Student successfully registered.");
    }

    public static  String generateId() {
        return UUID.randomUUID().toString();
    }

    public static void inputBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select book category:");
        System.out.println("1. Story Book");
        System.out.println("2. History Book");
        System.out.println("3. Text Book");
        System.out.print("Choose category (1-3): ");
        int categoryChoice = scanner.nextInt();

        System.out.print("Enter book title: ");
        String title = scanner.nextLine(); // Membersihkan buffer
        title = scanner.nextLine(); // Mengambil input judul

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter the stock: ");
        int stock = scanner.nextInt();

        // Menghasilkan ID buku secara otomatis
        String bookId = generateId();

        // Menambahkan buku ke dalam bookList
        if (categoryChoice >= 1 && categoryChoice <= 3) {
            String category = "";
            if (categoryChoice == 1) {
                category = "Story";
            } else if (categoryChoice == 2) {
                category = "History";
            } else if (categoryChoice == 3) {
                category = "Text";
            }
            System.out.println("Category: " + category);
            Book newBook = new Book(bookId, title, author, category, stock, 15);
            for (int i = 0; i < Main.bookList.length; i++) {
                if (Main.bookList[i] == null) {
                    Main.bookList[i] = newBook;
                    System.out.println("Book successfully added to the library.");
                    return;
                }
            }
            System.out.println("Book list is full.");
        } else {
            System.out.println("Invalid category choice.");
        }
    }

    public void menuAdmin(Scanner scanner) {
        boolean logout = false;
        while (!logout) {
            System.out.println("Admin Menu\n1. Add Student\n2. Display Registered Students\n3. Logout\nChoose option (1-3): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    logout = true;
                    System.out.println("Logging out from admin account.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}