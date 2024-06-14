package com.sof_3021.ph41964.repository;

import com.sof_3021.ph41964.entity.BillDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail,Integer> {

    @Query(value = "SELECT b FROM BillDetail b WHERE b.status=true")
    Page<BillDetail> getByPageActive(Pageable pageable);
}
