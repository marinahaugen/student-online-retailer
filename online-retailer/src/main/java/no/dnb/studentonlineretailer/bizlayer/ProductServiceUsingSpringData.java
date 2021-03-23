package no.dnb.studentonlineretailer.bizlayer;

import no.dnb.studentonlineretailer.datalayer.ProductSpringDataRepo;
import no.dnb.studentonlineretailer.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceUsingSpringData {

    @Autowired
    private ProductSpringDataRepo repo;

    public void doDemoSpringData() {

        try {
            Pageable pageable = PageRequest.of(0,3);
            System.out.println("\n--> 7. Testing findByNameContains():");
            Page<Product> page = repo.findByNameContains("Butt", pageable);
            System.out.printf("Page 1 of products containing \"Butt\": %s\n", page.getContent());

            System.out.println("\n--> 8. Testing findProductInPriceRange(20, 400):");
            System.out.println(repo.findProductInPriceRange(20, 400));

            System.out.println("\n--> 9. Testing findById(6):");
            System.out.println(repo.findById(6L));

        } catch (Exception ex)  {
            System.out.println(ex.getMessage());
        }

    }


}
