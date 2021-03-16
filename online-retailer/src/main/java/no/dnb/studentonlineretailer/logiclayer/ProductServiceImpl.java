package no.dnb.studentonlineretailer.logiclayer;

import no.dnb.studentonlineretailer.MyVatBean;
import no.dnb.studentonlineretailer.Product;
import no.dnb.studentonlineretailer.datalayer.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository stock;
    private final MyVatBean my25VatBean;
    private final MyVatBean my27VatBean;
    private final MyVatBean my50VatBean;

    @Autowired
    public ProductServiceImpl(ProductRepository stock, @Qualifier("my25VatBean") MyVatBean vat25, @Qualifier("my27VatBean") MyVatBean vat27, @Qualifier("my50VatBean") MyVatBean vat50) {
        this.stock = stock;
        this.my25VatBean = vat25;
        this.my27VatBean = vat27;
        this.my50VatBean = vat50;
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

    public double calculateVat(long id) {
        double productPrice = stock.getProductById(id).getPrice();
        if (productPrice < 100) {
            return my25VatBean.getVatPercentage() * productPrice;

        } else if (productPrice >= 100 && productPrice <= 10000){
            return my27VatBean.getVatPercentage() * productPrice;

        } else if (productPrice > 10000) {
            return my50VatBean.getVatPercentage() * productPrice;

        } else {
            System.out.println("Sorry, the ID you entered does not exist.");
            return -0.1;
        }
    }
}