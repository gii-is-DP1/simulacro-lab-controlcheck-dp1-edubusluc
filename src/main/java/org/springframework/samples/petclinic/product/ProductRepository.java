package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    //@Query("SELECT p FROM Product p") -> no hace falta por ser operacion crud
    List<Product> findAll();

    Optional<Product> findById(int id);
    Product findByName(String name);

    Product save(Product p);

    @Query("SELECT p FROM ProductType p WHERE p.name=?1")
    ProductType findProductType(String nombre);

    @Query("SELECT p FROM Product p WHERE p.price < ?1")
    List<Product> findByPriceLessThan(Double price);

    @Query("SELECT p FROM ProductType p")
    List<ProductType> findAllProductTypes();
}
