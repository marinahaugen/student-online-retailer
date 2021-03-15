package no.dnb.studentonlineretailer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductRepository stock;

    @Autowired
    public ProductServiceImpl(ProductRepository stock) {
        this.stock = stock;
    }

    @Override
    public void addToStock(int productId, String productName, double price) {
        System.out.printf("\nAdded %s with id: %d and price NOK %.2f.\n", productName, productId, price);
        stock.addProduct(productId, productName, price);
    }

    @Override
    public void deleteFromStock(int productId) {
        System.out.printf("\nTrying to delete product with id: %d...", productId);
        stock.deleteProduct(productId);
    }

    @Override
    public void updateStock(int productId, String productName, double price) {
        System.out.printf("\nUpdated product with id %d.", productId);
        stock.updateProduct(productId, productName, price);
    }

    @Override
    public Product findInStock(int productId) {
        return stock.findProductId(productId);
    }

}