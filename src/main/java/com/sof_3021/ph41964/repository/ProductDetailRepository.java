package com.sof_3021.ph41964.repository;

import com.sof_3021.ph41964.entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {

    @Query(value = "SELECT p FROM ProductDetail p WHERE p.status=true")
    Page<ProductDetail> getByPageActive(Pageable pageable);

    @Query(value = "SELECT p FROM ProductDetail p WHERE p.status=true AND p.code like %:search%")
    Page<ProductDetail> searchPageActive(@Param("search") String search, Pageable pageable);
}
