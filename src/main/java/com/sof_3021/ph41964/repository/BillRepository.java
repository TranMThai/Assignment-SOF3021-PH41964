package com.sof_3021.ph41964.repository;

import com.sof_3021.ph41964.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer> {

}
