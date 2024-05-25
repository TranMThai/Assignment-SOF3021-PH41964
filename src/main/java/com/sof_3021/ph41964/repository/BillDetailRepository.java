package com.sof_3021.ph41964.repository;

import com.sof_3021.ph41964.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail,Integer> {

}
