package com.sof_3021.ph41964.repository;

import com.sof_3021.ph41964.entity.Size;
import com.sof_3021.ph41964.service.SizeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<Size,Integer> {
}
