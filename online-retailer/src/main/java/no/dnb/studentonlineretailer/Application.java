package no.dnb.studentonlineretailer;

import no.dnb.studentonlineretailer.datalayer.ProductRepository;
import no.dnb.studentonlineretailer.bizlayer.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        ProductRepository repo = ctx.getBean("productRepositoryMemory", ProductRepository.class);
        repo.getAllProducts()
            .forEach(p -> System.out.println(p));

        ProductService productService = ctx.getBean(ProductService.class);
        //productService.adjustPriceByPercent(1,-10);
        double totalValue = productService.calculateTotalValue();
        System.out.printf("Total values: %.2f\n", totalValue);

        System.out.println("\nVAT for product 1:");
        System.out.println(productService.getVatByPrice(90));
        System.out.println("\nVAT for product 2:");
        System.out.println(productService.getVatByPrice(200));
        System.out.println("\nVAT for product 3:");
        System.out.println(productService.getVatByPrice(20000));

    }
}
