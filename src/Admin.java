import util.iMenu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Admin extends User implements iMenu {
    static final Map<String, String[]> userStudent = new HashMap<>();
    private static final HashMap<String, String> ADMIN_DATA = new HashMap<>();

    static {
        ADMIN_DATA.put("admin", "admin");
    }
    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
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


    public void displayStudents() {
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

        userStudent.put(nim, new String[]{name, faculty, program});
        System.out.println("Student successfully registered.");
    }

    public static  String generateId() {
        return UUID.randomUUID().toString();
    }


//    public void menuAdmin(Scanner scanner) {
//        boolean logout = false;
//        while (!logout) {
//            System.out.println("Admin Menu\n1. Add Student\n2. Display Registered Students\n3. Logout\nChoose option (1-3): ");
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    addStudent(scanner);
//                    break;
//                case 2:
//                    displayStudents();
//                    break;
//                case 3:
//                    logout = true;
//                    System.out.println("Logging out from admin account.");
//                    break;
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        }
//    }
}