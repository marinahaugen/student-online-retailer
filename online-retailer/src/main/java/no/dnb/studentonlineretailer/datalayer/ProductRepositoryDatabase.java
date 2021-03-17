package no.dnb.studentonlineretailer.datalayer;

import no.dnb.studentonlineretailer.models.Product;

import java.util.Collection;

public class ProductRepositoryDatabase implements ProductRepository {


    @Override
    public Collection<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public Product insertProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(long id) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }
}
