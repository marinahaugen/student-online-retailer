package no.dnb.studentonlineretailer.logiclayer;

import no.dnb.studentonlineretailer.Product;

import java.util.Collection;

public interface ProductService {

    double calculateTotalValue();
    Collection<Product> getLowStuckProducts(long threshold);
    double getAveragePrice();
    void adjustPriceByPercent(long id, double percent);

}
