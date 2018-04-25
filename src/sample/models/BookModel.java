package sample.models;

public class BookModel {
    private String id_book;
    private String name_book;
    private String category_book;
    private int cost_book;
    private String author_book;
    private String date_add_book;
    private int total_book;

    public BookModel(String id_book, String name_book, String category_book, int cost_book, String author_book, String date_add_book, int total_book) {
        this.id_book = id_book;
        this.name_book = name_book;
        this.category_book = category_book;
        this.cost_book = cost_book;
        this.author_book = author_book;
        this.date_add_book = date_add_book;
        this.total_book = total_book;
    }

    public String getId_book() {
        return id_book;
    }

    public void setId_book(String id_book) {
        this.id_book = id_book;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getCategory_book() {
        return category_book;
    }

    public void setCategory_book(String category_book) {
        this.category_book = category_book;
    }

    public int getCost_book() {
        return cost_book;
    }

    public void setCost_book(int cost_book) {
        this.cost_book = cost_book;
    }

    public String getAuthor_book() {
        return author_book;
    }

    public void setAuthor_book(String author_book) {
        this.author_book = author_book;
    }

    public String getDate_add_book() {
        return date_add_book;
    }

    public void setDate_add_book(String date_add_book) {
        this.date_add_book = date_add_book;
    }

    public int getTotal_book() {
        return total_book;
    }

    public void setTotal_book(int total_book) {
        this.total_book = total_book;
    }
}


