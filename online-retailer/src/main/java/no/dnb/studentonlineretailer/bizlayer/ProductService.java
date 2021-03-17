package no.dnb.studentonlineretailer.bizlayer;

import no.dnb.studentonlineretailer.models.Product;

import java.util.Collection;

public interface ProductService {

    double calculateTotalValue();
    Collection<Product> getLowStuckProducts(long threshold);
    double getAveragePrice();
    void adjustPriceByPercent(long id, double percent);
    public double getVatByPrice(double price);

}
