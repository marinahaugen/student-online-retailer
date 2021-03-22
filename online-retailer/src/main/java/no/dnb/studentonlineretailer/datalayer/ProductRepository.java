package no.dnb.studentonlineretailer.datalayer;

import no.dnb.studentonlineretailer.models.Product;

import java.util.Collection;

public interface ProductRepository {

    // Save data to database. Doer
    // Create, Read, Update, Delete

    Collection<Product> getAllProducts();
    Product getProductById(long id);
    void insertProduct(Product product);
    boolean deleteProduct(long id);
    boolean updateProduct(Product product);
    long getProductCount();
    boolean setPriceForProduct (long id, double price);
}
