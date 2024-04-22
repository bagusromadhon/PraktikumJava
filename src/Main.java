import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static boolean loggedIn = false;
    static final Map<String, String[]> userStudent = new HashMap<>();
    static final HashMap<String, String> ADMIN_DATA = new HashMap<>();
    static final HashMap<String, String> STUDENT_DATA = new HashMap<>();
    static  Book[] bookList = new Book[50];
    static {
        ADMIN_DATA.put("admin", "admin");
        STUDENT_DATA.put("123", "123");


        bookList[0] = new Book("1", "title 1", "author 1", "History", 5, 10);


    }



    public static void main(String[] args) {
        if (!loggedIn){
            Menu();
        }

    }

    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Library System\n1. Login as Student\n2. Login as Admin\n3. Exit\nChoose option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    loginAsStudent(scanner);
                    break;
                case 2:
                    loginAsAdmin(scanner);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you. Exiting Program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void loginAsStudent(Scanner scanner) {
        if (loggedIn) {
            System.out.println("You are already logged in.");
            return;
        }
        System.out.println(loggedIn);
        System.out.print("Enter your NIM: ");
        String nim = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        if (STUDENT_DATA.containsKey(nim) && STUDENT_DATA.get(nim).equals(password)) {
            loggedIn = true;
            System.out.println("Login as student successful!");
            // Implement student menu here
            System.out.println("Student Menu\n1. Buku terpinjam\n2. Pinjam Buku\n3. Kembalikan buku \n4. Pinjam Buku atau logout\nChoose Option (1-4): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Student.showBorrowedBooks();
                    break;
                case 2:
                    Student.borrowBook(bookList, scanner);
                    break;
                case 3:
                    Student.returnBook(bookList, scanner);
                    break;
                case 4:
                    System.out.println("1. Pinjam Buku\n2. Logout");
                    int subChoice = scanner.nextInt();
                    switch (subChoice) {
                        case 1:
                            Student.borrowBook(bookList, scanner);
                            break;
                        case 2:
                            System.out.println("Logout");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } else {
            System.out.println("Invalid NIM or password. Please try again.");
        }
    }

    public static void loginAsAdmin(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        if (ADMIN_DATA.containsKey(username) && ADMIN_DATA.get(username).equals(password)) {
            System.out.println("Login as admin successful!");
            adminMenu(scanner);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    public static void adminMenu(Scanner scanner) {
        boolean logout = false;
        while (!logout) {
            System.out.println("Admin Menu\n1. Add Student\n2. Display Registered Students\n3. Add book \n4. Display Available Books\n5. Logout\nChoose option (1-4): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Admin.addStudent(scanner);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    Admin.inputBook();
                    break;
                case 4:
                    User.displayBooks(bookList);
                    break;
                case 5:
                    logout = true;
                    System.out.println("Logging out from admin account.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }



    public static void displayStudents() {
        System.out.println("List of Registered Students:");
        for (Map.Entry<String, String[]> entry : userStudent.entrySet()) {
            String nim = entry.getKey();
            String[] studentInfo = entry.getValue();
            System.out.println("Name: " + studentInfo[0]);
            System.out.println("Faculty: " + studentInfo[1]);
            System.out.println("NIM: " + nim);
            System.out.println("Program: " + studentInfo[2]);
            System.out.println();
        }
    }


}



