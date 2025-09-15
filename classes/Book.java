package classes;

public class Book {
    private String name;
    private String author;
    private double price;
    private int quantity;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.quantity = 1;
    }

    public Book(String name, String author, double price, int quantity) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    public void decrementQuantity() {
        if (this.quantity > 1) {
            this.quantity--;
        }
    }
}
