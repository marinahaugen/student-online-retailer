package no.dnb.studentonlineretailer.bizlayer;

import no.dnb.studentonlineretailer.datalayer.ProductSpringDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceUsingSpringData {

    @Autowired
    private ProductSpringDataRepo repo;

    public void doDemoSpringData() {

        try {
            Pageable pageable = PageRequest.of(1,3);
            System.out.println("\n--> 7. Testing findProductByNameContains():");
            System.out.println(repo.findProductByNameContains("Blue", pageable));

            System.out.println("\n--> 8. Testing findProductInPriceRange(20, 400):");
            System.out.println(repo.findProductInPriceRange(20, 400));

            System.out.println("\n--> 9. Testing findById(6):");
            System.out.println(repo.findById(6L));

        } catch (Exception ex)  {
            System.out.println(ex.getMessage());
        }

    }


}
