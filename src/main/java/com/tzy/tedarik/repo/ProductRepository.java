package com.tzy.tedarik.repo;

import com.tzy.tedarik.model.products.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select (count(p) > 0) from Product p where p.productName = ?1")
    boolean existsProductNameBy(String productName);
}