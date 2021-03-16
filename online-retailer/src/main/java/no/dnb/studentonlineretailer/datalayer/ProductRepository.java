package no.dnb.studentonlineretailer.datalayer;

import no.dnb.studentonlineretailer.Product;

import java.util.Collection;

public interface ProductRepository {

    // Save data to database. Doer
    // Create, Read, Update, Delete

    Collection<Product> getAllProducts();
    Product getProductById(long id);
    Product insertProduct(Product product);
    boolean deleteProduct(int productId);
    boolean updateProduct(Product product);

}
