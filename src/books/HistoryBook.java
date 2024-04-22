package books;

public class HistoryBook extends Book {
    public HistoryBook(String bookId, String title, String author,String category, int stock, int duration) {
        super(bookId, title, author, category,stock,duration);
        this.setCategory("History");
    }
}