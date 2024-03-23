package ma.emsi.assignementg62.repository;

import ma.emsi.assignementg62.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product p")
    List<Product> Consulter();

    @Query("select p from Product p where p.id = :x")
    List<Product> consulterProd(@Param("x") long mc);





}
