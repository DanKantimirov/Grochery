package ru.crazycorp.grochery.wsproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.crazycorp.grochery.wsproduct.entity.database.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
