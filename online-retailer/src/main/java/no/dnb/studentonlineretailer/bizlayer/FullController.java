package no.dnb.studentonlineretailer.bizlayer;

import no.dnb.studentonlineretailer.datalayer.ProductRepository;
import no.dnb.studentonlineretailer.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
public class FullController {

    @Qualifier("productRepositoryDatabase")
    @Autowired
    private ProductRepository repository;

    @GetMapping(value="/products/{id}", produces = "application/json")
    public ResponseEntity<Product> getProductById (@PathVariable long id) {
        Product p = repository.getProductById(id);
        if (p == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(p);
        }
    }

    @GetMapping(value="/products", produces = "application/json")
    public ResponseEntity<Collection<Product>> getProductsMoreThan(@RequestParam(value="min", required = false, defaultValue="0.0") double min) {
        Collection<Product> products = repository.getAllProducts()
                                                 .stream()
                                                 .filter(p -> p.getPrice() > min)
                                                 .collect(Collectors.toList());
        return ResponseEntity.ok().body(products);
    }




}
