package com.sof_3021.ph41964.repository;

import com.sof_3021.ph41964.entity.Customer;
import com.sof_3021.ph41964.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "SELECT c FROM Customer c WHERE c.status=true")
    Page<Customer> getByPageActive(Pageable pageable);

    @Query(value = "SELECT c FROM Customer c WHERE c.status=true AND c.code like %:search% OR c.name like %:search% OR c.phoneNumber like %:search%")
    Page<Customer> searchPageActive(@Param("search") String search, Pageable pageable);

}
