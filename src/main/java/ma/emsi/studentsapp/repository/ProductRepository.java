package ma.emsi.studentsapp.repository;


import ma.emsi.studentsapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByNameContains(String a);
    List<Product> findByPriceGreaterThan(double price);
    @Query("select p from Product p where p.name like :x")
    List<Product> search(@Param("x") String a);

    @Query("select p from Product p where p.price>:x")
    List<Product> searchByPrice(@Param("x") double price);


  //  @Query("delete from Product p where p.id = :id")

   // List<Product> deleteProductById(@Param("id") Long id);
}
