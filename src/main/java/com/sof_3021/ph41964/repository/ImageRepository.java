package com.sof_3021.ph41964.repository;

import com.sof_3021.ph41964.entity.Image;
import com.sof_3021.ph41964.service.ImageService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {
}
