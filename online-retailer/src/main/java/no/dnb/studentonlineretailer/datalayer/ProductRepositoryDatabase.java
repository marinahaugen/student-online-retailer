package no.dnb.studentonlineretailer.datalayer;

import no.dnb.studentonlineretailer.models.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class ProductRepositoryDatabase implements ProductRepository {

    // Can't just autowire an EntityManager, the EntityManagerFactory has to make it. Use @PersistenceContext
    // This is the "EntityManager" equivalent of @Autowired.
    // It uses the EntityManagerFactory bean implicitly to create an EntityManager object for us

    @PersistenceContext
    private EntityManager entityManager;

    public long getProductCount() {
        String jpql ="select count(p) from Product p";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        return query.getSingleResult();
    }

    @Override
    public Collection<Product> getAllProducts() {
        String jpql = "select p from Product p";
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        return query.getResultList();
    }

    @Override
    public Product getProductById(long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    public void insertProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    @Transactional
    public boolean deleteProduct(long id) {
        Product entity = entityManager.find(Product.class, id);
        if (entity == null) {
            return false;
        } else {
            entityManager.remove(entity);
            return true;
        }
    }

    @Override
    @Transactional
    public boolean updateProduct(Product product) {
        Product entity = entityManager.find(Product.class, product.getId());
        if (entity == null) {
            return false;
        } else {
            entity.getName();
            entity.getPrice();
            entity.getInStock();
            return true;
        }
    }

}
