import books.Book;
import util.iMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Student extends User implements iMenu {
    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean logout = false;
        while (!logout) {
            System.out.println("Student Menu\n1. Buku terpinjam\n2. Pinjam Buku\n3. Kembalikan buku \n4. Pinjam Buku atau logout\nChoose Option (1-4): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showBorrowedBooks();
                    break;
                case 2:
                    borrowBook(User.bookList, scanner);
                    break;
                case 3:
                    returnBook(User.bookList, scanner);
                    break;
                case 4:
                    System.out.println("1. Pinjam Buku\n2. Logout");
                    int subChoice = scanner.nextInt();
                    switch (subChoice) {
                        case 1:
                            borrowBook(User.bookList, scanner);
                            break;
                        case 2:
                            logout = true;
                            System.out.println("Logging out from student account.");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    private static final int MAX_BORROW_DAYS = 14;
    private static List<Book> borrowedBooks = new ArrayList<>();

    public static void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("Belum ada buku yang dipinjam");
        } else {
            System.out.println("Buku yang dipinjam:");
            System.out.println("=================================================================================");
            System.out.println("|| No.|| Id buku || Nama Buku || Author || Category || Durasi ||");
            System.out.println("=================================================================================");
            for (int i = 0; i < borrowedBooks.size(); i++) {
                Book book = borrowedBooks.get(i);
                System.out.println("|| " + (i + 1) + " || " + book.getBookId() + " || " + book.getTitle() + " || " +
                        book.getAuthor() + " || " + book.getCategory() + " || " + book.getDuration() + " ||");
            }
            System.out.println("=================================================================================");
        }
    }

    public static void borrowBook(Book[] bookList, Scanner scanner) {
        System.out.println("Daftar Buku Tersedia:");
        User.displayBooks(bookList);
        System.out.println("Input Id buku yang ingin dipinjam (input '99' untuk kembali)");
        String bookId = scanner.next();
        if (bookId.equals("99")) {
            System.out.println("Kembali ke menu awal...");
            return;
        }
        Book book = findBookById(bookList, bookId);
        if (book == null) {
            System.out.println("Buku tidak ditemukan");
        } else if (book.getStock() <= 0) {
            System.out.println("Stock buku kosong! Silahkan pilih yang lain.");
        } else {
            System.out.print("Berapa lama buku akan dipinjam? (maksimal 14 hari) ");
            int duration = scanner.nextInt();
            if (duration > MAX_BORROW_DAYS) {
                System.out.println("Maksimal durasi peminjaman adalah 14 hari.");
                return;
            }
            book.setStock(book.getStock() - 1);
            book.setDuration(duration);
            borrowedBooks.add(book);
            System.out.println("Peminjaman buku berhasil dilakukan");
        }
    }

    public static void returnBook(Book[] bookList, Scanner scanner) {
        if (borrowedBooks.isEmpty()) {
            System.out.println("Belum ada buku yang dipinjam");
            return;
        }
        System.out.println("Buku yang dipinjam:");
        showBorrowedBooks();
        System.out.println("Input Id buku yang ingin dikembalikan (input '99' untuk kembali)");
        String bookId = scanner.next();
        if (bookId.equals("99")) {
            System.out.println("Kembali ke menu awal...");
            return;
        }
        Book book = findBookById(borrowedBooks.toArray(new Book[0]), bookId);
        if (book == null) {
            System.out.println("Buku tidak ditemukan dalam daftar yang dipinjam");
        } else {
            borrowedBooks.remove(book);
            for (Book b : bookList) {
                if (b != null && Objects.equals(b.getBookId(), bookId)) {
                    b.setStock(b.getStock() + 1);
                    break;
                }
            }
            System.out.println("Pengembalian buku berhasil dilakukan");
        }
    }

    private static Book findBookById(Book[] books, String bookId) {
        for (Book book : books) {
            if (book != null && book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }


    public static void choiceBook(Book[] bookList) {

        System.out.println("List Buku");
        System.out.println("NO\tid buku\t\tnamabuku\t\tauthor\t\tcategory\tstock\t\tduration\t");
        int nomer=0;
        for (Book book : bookList) {
            if (book != null) {
                nomer++;
                System.out.println(nomer + "\t" + book.getBookId() + "\t\t" + book.getTitle() + "\t\t" +
                        book.getAuthor() + "\t\t" + book.getCategory() + "\t\t" + book.getStock() + "\t\t" + book.getDuration());
            }
        }

    }


//    public static void menu(Scanner scanner){
//        System.out.println("Student Menu\n1. Buku terpinjam\n2. Pinjam Buku\n3. Kembalikan buku \n4. Pinjam Buku atau logout\nChoose Option (1-4): ");
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    Student.showBorrowedBooks();
//                    break;
//                case 2:
//                    Student.borrowBook(User.bookList, scanner);
//                    break;
//                case 3:
//                    Student.returnBook(User.bookList, scanner);
//                    break;
//                case 4:
//                    System.out.println("1. Pinjam Buku\n2. Logout");
//                    int subChoice = scanner.nextInt();
//                    switch (subChoice) {
//                        case 1:
//                            Student.borrowBook(User.bookList, scanner);
//                            break;
//                        case 2:
//                            System.out.println("Logout");
//                            break;
//                        default:
//                            System.out.println("Invalid choice.");
//                    }
//                    break;
//                default:
//                    System.out.println("Invalid choice.");
//            }
//    }
}
