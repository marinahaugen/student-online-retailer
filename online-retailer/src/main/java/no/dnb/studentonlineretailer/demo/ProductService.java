package no.dnb.studentonlineretailer.demo;

public interface ProductService {

    void addToStock(int productId, String productName, double price);
    void deleteFromStock(int productId);
    void updateStock(int productId, String productName, double price);
    Product findInStock(int productId);

}
