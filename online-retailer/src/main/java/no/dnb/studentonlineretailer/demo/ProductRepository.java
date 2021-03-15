package no.dnb.studentonlineretailer.demo;

public interface ProductRepository {

    void addProduct(int productId, String productName, double price);
    boolean deleteProduct(int productId);
    void updateProduct(int productId, String productName, double price);
    Product findProductId(int productId);

}
