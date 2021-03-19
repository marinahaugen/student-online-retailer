package no.dnb.studentonlineretailer.datalayer;

import no.dnb.studentonlineretailer.models.Product;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Lazy
public interface ProductSpringDataRepo extends CrudRepository<Product, Long> {

    @Query("select prod from Product prod where prod.price >= ?1 and prod.price <= ?2")
    List<Product> findProductInPriceRange(double from, double to);

    Page<Product> findProductByNameContains(String string);

}
