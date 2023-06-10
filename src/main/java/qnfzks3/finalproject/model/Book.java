package qnfzks3.finalproject.model;

public class Book {
    private String bookid;   //도서ID
    private String bkname;    //도서명

    private int unitPrice; //가격

    private String author; //저자
    private String description; // 설명
    private String publisher; //저자
    private String category; //분류
    private Integer unitsInStock; // 재고 수
    private String releaseDate; // 출판일(월/년)
    private String cobd; //신규 도서 또는 중고 도서 , 전자책

    public Book() {
    }

    public Book(String bookid, String bkname, int unitPrice, String author, String description, String publisher, String category, Integer unitsInStock, String releaseDate, String cobd) {
        this.bookid = bookid;
        this.bkname = bkname;
        this.unitPrice = unitPrice;
        this.author = author;
        this.description = description;
        this.publisher = publisher;
        this.category = category;
        this.unitsInStock = unitsInStock;
        this.releaseDate = releaseDate;
        this.cobd = cobd;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCobd() {
        return cobd;
    }

    public void setCobd(String cobd) {
        this.cobd = cobd;
    }
}