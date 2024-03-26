import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Student {
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
}
