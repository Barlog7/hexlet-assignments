package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    //Optional<Product> findByPrice(int price);
    //List<Product> findAllByEmail(String email);
    List<Product> findByPriceBetweenOrderByPrice(Integer startPrie, Integer endPrice);
    List<Product> findByPriceLessThanOrderByPrice(Integer endPrice);
    List<Product> findByPriceGreaterThanOrderByPrice(Integer startPrie);

    // END
}
