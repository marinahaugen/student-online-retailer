package no.dnb.studentonlineretailer.datalayer;

import no.dnb.studentonlineretailer.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepositoryMemory implements ProductRepository {

    private final Map<Long, Product> stock = new HashMap<>();
    private static long nextId = 1;

    public ProductRepositoryMemory() {
        insertProduct(new Product("Product1", 90, 5));
        insertProduct(new Product("Product2", 200, 1));
        insertProduct(new Product("Product3", 20000, 3));
    }

    @Override
    public Collection<Product> getAllProducts() {
        return stock.values();
    }

    @Override
    public Product getProductById(long id) {
        return stock.get(id);
    }

    public void insertProduct(Product product) {
        if (product.getId() != -1) {                    //Precondition
            throw new IllegalArgumentException("\nId for product-to-be-inserted must be -1.");
        }
        product.setId(nextId++);                        //set id and then post-increment
        stock.put(product.getId(), product);            //enriched with id
    }

    @Override
    public boolean deleteProduct(long productId) {
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

    public long getProductCount() {
        return 0;
    }

}
