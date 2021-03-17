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

    private final ProductRepository stock; //@Qualifier to the database-repo??
    private final VatSetup vatSetup;

    @Autowired
    public ProductServiceImpl(ProductRepository stock, VatSetup vatSetup) {
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
}