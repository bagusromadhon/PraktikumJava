package Model;

public class Book {
    private int id_buku;
    private String author;
    private String judul;
    private int stock_buku;

    public int getId_buku() {
        return id_buku;
    }

    public void setId_buku(int id_buku) {
        this.id_buku = id_buku;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getStock_buku() {
        return stock_buku;
    }

    public void setStock_buku(int stock_buku) {
        this.stock_buku = stock_buku;
    }
}
