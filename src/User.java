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

    public static void main(String[] args) {

    }


}
