package no.dnb.studentonlineretailer.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private HashMap<Integer, Product> stock = new HashMap<Integer, Product>();

    @Override
    public void addProduct(int productId, String productName, double price) {
        stock.put(productId, new Product(productId, productName, price));
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
    public void updateProduct(int productId, String productName, double price) {
        stock.replace(productId, new Product(productId, productName, price));
    }

    @Override
    public Product findProductId(int productId) {
        if (!stock.containsKey(productId)) {
            System.out.println("\nSorry we don't have that productId.");
            return null;
        } else {
            System.out.printf("\nYou searched for %d. The result is: ", productId);
            System.out.println(stock.get(productId));
            return stock.get(productId);
        }

    }
}
