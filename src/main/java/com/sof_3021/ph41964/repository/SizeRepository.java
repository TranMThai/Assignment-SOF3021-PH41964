package com.sof_3021.ph41964.repository;

import com.sof_3021.ph41964.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size,Integer> {

    @Query(value = "SELECT s FROM Size s WHERE s.status=true")
    Page<Size> getByPageActive(Pageable pageable);

    @Query(value = "SELECT s FROM Size s WHERE s.status=true AND s.code like %:search% OR s.name like %:search%")
    Page<Size> searchPageActive(@Param("search") String search, Pageable pageable);

}
