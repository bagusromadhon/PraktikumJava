
// Superclass Book
public class Book {
    private int bookId;
    private String title;
    private String author;
    private String category;
    private int stock;
    private int duration;


    public Book(int bookId, String title, String author, String category,int stock,int duration) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.duration = duration;
    }


    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Getter methods
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public int getDuration() {
        return duration;
    }
}