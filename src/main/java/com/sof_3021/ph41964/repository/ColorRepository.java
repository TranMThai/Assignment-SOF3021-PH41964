package com.sof_3021.ph41964.repository;

import com.sof_3021.ph41964.entity.Color;
import com.sof_3021.ph41964.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color,Integer> {

    @Query(value = "SELECT c FROM Color c WHERE c.status=true")
    Page<Color> getByPageActive(Pageable pageable);

    @Query(value = "SELECT c FROM Color c WHERE c.status=true AND c.code like %:search% OR c.name like %:search%")
    Page<Color> searchPageActive(@Param("search") String search, Pageable pageable);

}
