package no.dnb.studentonlineretailer.datalayer;

import no.dnb.studentonlineretailer.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private Map<Long, Product> stock = new HashMap<>();
    private static long nextId = 1;

    public ProductRepositoryImpl() {
        insertProduct(new Product("Product1", 1000, 5));
    }

    @Override
    public Collection<Product> getAllProducts() {
        return stock.values();
    }

    @Override
    public Product getProductById(long id) {
        return stock.get(id);
    }

    public Product insertProduct(Product product) {
        if (product.getId() != -1) {                    //Precondition
            throw new IllegalArgumentException("\nId for product-to-be-inserted must be -1.");
        }
        product.setId(nextId++);                        //set id and then post-increment
        stock.put(product.getId(), product);
        return product;                                 //enriched with id
    }

    @Override
    public boolean deleteProduct(int productId) {
        if (!stock.containsKey(productId)) {
            System.out.println("\n--> Sorry we don't have that productId.");
            return false;
        } else {
            stock.remove(productId);
            System.out.println("\n--> Success!");
            return true;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        long id = product.getId();
        if (!stock.containsKey(id)) {
            return false;
        } else {
            stock.replace(id, product);
            return true;
        }
    }

}
