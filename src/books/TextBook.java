package books;

public class TextBook extends Book {
    public TextBook(String bookId, String title, String author,String category, int stock, int duration) {
        super(bookId, title, author, category,stock,duration);
        this.setCategory("Text");
    }
}