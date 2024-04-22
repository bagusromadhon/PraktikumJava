package books;

public class StoryBook extends Book {
    public StoryBook(String bookId, String title, String author,String category, int stock, int duration) {
        super(bookId, title, author, category,stock,duration);
        this.setCategory("Story");
    }
}