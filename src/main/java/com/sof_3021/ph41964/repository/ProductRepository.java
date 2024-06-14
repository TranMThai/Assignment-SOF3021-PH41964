package com.sof_3021.ph41964.repository;

import com.sof_3021.ph41964.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT p FROM Product p WHERE p.status=true")
    Page<Product> getByPageActive(Pageable pageable);

    @Query(value = "SELECT p FROM Product p WHERE p.status=true AND p.code like %:search% OR p.name like %:search%")
    Page<Product> searchPageActive(@Param("search") String search, Pageable pageable);
}
