package no.dnb.studentonlineretailer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="PRODUCTS")
public class Product {

    // Passive class. Make the object that should be stored.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double price;

    @Column(name="instock")
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

    public void setName(String name) {
        this.name = name;
    }

    public void setInStock(long inStock) {
        this.inStock = inStock;
    }

    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Product) {
            Product otherProduct = (Product) other;
            result = (this.id == otherProduct.id);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return (int)id;
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
