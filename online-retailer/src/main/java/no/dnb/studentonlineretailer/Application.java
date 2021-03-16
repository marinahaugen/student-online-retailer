package no.dnb.studentonlineretailer;

import no.dnb.studentonlineretailer.datalayer.ProductRepository;
import no.dnb.studentonlineretailer.logiclayer.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        ProductRepository repo = ctx.getBean("productRepositoryImpl", ProductRepository.class);
        repo.getAllProducts()
            .stream().forEach(p -> System.out.println(p));

        ProductService productService = ctx.getBean(ProductService.class);
        //productService.adjustPriceByPercent(1,-10);
        double totalValue = productService.calculateTotalValue();
        System.out.printf("Total values: %.2f", totalValue);

        System.out.println(productService.calculateVat(1));

    }
}
