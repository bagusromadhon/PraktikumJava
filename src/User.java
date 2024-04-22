import books.Book;

import java.util.Scanner;

public class User {
    static  Book[] bookList = new Book[50];

    static {
        bookList[0] = new Book("1", "title 1", "author 1", "History", 5, 10);
    }

    public static void displayBooks(Book[] bookList) {

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

    public static void addBook(){

    }

    public static void inputBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select book category:");
        System.out.println("1. Story books.Book");
        System.out.println("2. History books.Book");
        System.out.println("3. Text books.Book");
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
        String bookId = Admin.generateId();

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
                    System.out.println("books.Book successfully added to the library.");
                    return;
                }
            }
            System.out.println("books.Book list is full.");
        } else {
            System.out.println("Invalid category choice.");
        }
    }


    public static void main(String[] args) {

    }


}
