package no.dnb.studentonlineretailer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

        ProductService productService = ctx.getBean(ProductService.class);
        productService.addToStock(1,"Flowers", 200);
        productService.deleteFromStock(2);
        //productService.deleteFromStock(1);
        productService.findInStock(1);
        productService.updateStock(1, "Blue flowers", 55);
    }

}
