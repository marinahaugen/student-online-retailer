package no.dnb.studentonlineretailer;

public class Product {

    // Passive class. Make the object that should be stored.

    private long id;
    private String name;
    private double price;
    private long inStock;

    public Product() {}

    public Product(String name, double price, long inStock) {
        this(-1, name, price, inStock);

    }

    public Product(long id, String name, double price, long inStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInStock() {
        return inStock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void adjustPriceByPercent(double percent) {
        price *= 1+ percent/100;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inStock='" + inStock + '\'' +
                ", price=" + price +
                '}';
    }


}
