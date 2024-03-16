package ma.emsi.assignementg62.repository;

import ma.emsi.assignementg62.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
