package no.dnb.studentonlineretailer.demo;

public interface ProductRepository {

    // FROM ANDY: It's usually OK for this method to take a "whole" Product object, rather than separate params.
    // Typically you don't know the "id" until after it has been inserted into the database. I'll discuss this on Tuesday.
    void addProduct(int productId, String productName, double price);

    boolean deleteProduct(int productId);
    
    // FROM ANDY: It's usually OK for this method to take a "whole" Product object, rather than separate params.
    void updateProduct(int productId, String productName, double price);

    Product findProductId(int productId);

}
