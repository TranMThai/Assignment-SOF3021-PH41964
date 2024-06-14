package com.sof_3021.ph41964.repository;

import com.sof_3021.ph41964.entity.Employee;
import com.sof_3021.ph41964.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {

    @Query(value = "SELECT e FROM Employee e WHERE e.status=true")
    Page<Employee> getByPageActive(Pageable pageable);

    @Query(value = "SELECT e FROM Employee e WHERE e.status=true AND e.code like %:search% OR e.name like %:search% OR e.username like %:search%")
    Page<Employee> searchPageActive(@Param("search") String search, Pageable pageable);

}
