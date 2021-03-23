package no.dnb.studentonlineretailer.bizlayer;

import no.dnb.studentonlineretailer.datalayer.ProductRepository;
import no.dnb.studentonlineretailer.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
public class FullController {

    @Qualifier("productRepositoryDatabase")
    @Autowired
    private ProductRepository repository;

    @GetMapping(value = "/products/{id}", produces = "application/json")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Product p = repository.getProductById(id);
        if (p == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(p);
        }
    }

    //optional param
    @GetMapping(value = "/products", produces = "application/json")
    public ResponseEntity<Collection<Product>> getProductsMoreThan(@RequestParam(value = "min", required = false, defaultValue = "0.0") double min) {
        Collection<Product> products = repository.getAllProducts()
                .stream()
                .filter(p -> p.getPrice() > min)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(products);
    }

    @GetMapping (value = "/products/averagePrice", produces = "application/json")
    public ResponseEntity<Double> getAveragePrice() {
        double average = repository.getAllProducts()
                                   .stream()
                                   .mapToDouble(Product::getPrice)
                                   .average()
                                   .orElse(0);
                return ResponseEntity.ok().body(average);
    }

    @PostMapping(value = "/products", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
        repository.insertProduct(product);
        URI uri = URI.create("/products/" + product.getId());
        return ResponseEntity.created(uri).body(product);
    }


    @PutMapping(value = "/products/{id}/setPrice/{price}", consumes = {"application/json"})
    public ResponseEntity<Void> setProduct(@PathVariable long id, @PathVariable double price) {
        if (!repository.setPriceForProduct(id, price)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping(value = "/products/{id}", consumes = {"application/json"})
    public ResponseEntity<Void> updateProduct(@PathVariable long id, @RequestBody Product product) {
        if (!repository.updateProduct(product)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }



    @DeleteMapping("products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        if (!repository.deleteProduct(id)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }


}
