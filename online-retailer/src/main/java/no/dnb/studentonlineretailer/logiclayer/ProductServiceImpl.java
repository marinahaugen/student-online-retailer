package no.dnb.studentonlineretailer.logiclayer;

import no.dnb.studentonlineretailer.Product;
import no.dnb.studentonlineretailer.datalayer.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository stock;

    @Autowired
    public ProductServiceImpl(ProductRepository stock) {
        this.stock = stock;
    }

    @Override
    public double calculateTotalValue() {
        double totalValue = stock.getAllProducts()
                                 .stream()
                                 .mapToDouble(p -> p.getPrice() * p.getInStock())
                                 .sum();
        return totalValue;
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
        } else {
            theProduct.adjustPriceByPercent(byPercent);
            stock.updateProduct(theProduct);
        }

    }
}