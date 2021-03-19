package no.dnb.studentonlineretailer.bizlayer;

import no.dnb.studentonlineretailer.models.Product;
import no.dnb.studentonlineretailer.datalayer.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository stock;
    private final VatSetup vatSetup;

    @Autowired
    public ProductServiceImpl(@Qualifier("productRepositoryDatabase") ProductRepository stock, VatSetup vatSetup) {
        this.stock = stock;
        this.vatSetup = vatSetup;
    }

    @Override
    public double calculateTotalValue() {
        return stock.getAllProducts()
                    .stream()
                    .mapToDouble(p -> p.getPrice() * p.getInStock())
                    .sum();
    }

    @Override
    public Collection<Product> getLowStuckProducts(long threshold) {
        return stock.getAllProducts()
                    .stream()
                    .filter(p -> p.getInStock()<threshold)
                    .collect(Collectors.toList());
    }

    @Override
    public double getAveragePrice() {
        return stock.getAllProducts()
                    .stream()
                    .mapToDouble(p -> p.getPrice())
                    .average()
                    .orElse(0.0);
    }

    @Override
    public void adjustPriceByPercent(long id, double byPercent) {
        Product theProduct = stock.getProductById(id);
        if (theProduct == null) {
            System.out.println("The product id does not exist.");
        } else {
            theProduct.adjustPriceByPercent(byPercent);
            stock.updateProduct(theProduct);
        }
    }

    public double getVatByPrice(double price) {
        return vatSetup.getVatPercentageByPrice(price);
    }

    public void doDemo() {

        try {
            long counter = stock.getProductCount();
            System.out.printf("\n--> 1. Testing getProductCount(): There are %d different products in stock.", counter);

            System.out.println("\n--> 2. Testing getAllProducts(): These are all the products we have.");
            displayProducts(stock);

            System.out.printf("\n--> 3. Testing getProductById(id): Product with id 1 is:\n");
            System.out.println(stock.getProductById(1));

            System.out.println("\n--> 4. Testing insertProduct(product): Added \"Blue flower\" for 55 kr. We have 30 in stock.");
            Product newProduct = new Product("Blue flower", 55, 30);
            stock.insertProduct(newProduct);
            displayProducts(stock);

            System.out.println("\n--> 5. Testing deleteProduct(1):");
            stock.deleteProduct(1);
            displayProducts(stock);

            System.out.println("\n--> 6. Testing updateProduct(2):");
            Product prod = stock.getProductById(2);
            stock.updateProduct(prod);                                  //How do you enter the new values?? Lets say I want to change name form "Game" to "The Sims"
            displayProducts(stock);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void displayProducts(ProductRepository stock) {
        System.out.println("******Products in stock: ");
        stock.getAllProducts().stream().forEach(p -> System.out.println(p));
    }
}