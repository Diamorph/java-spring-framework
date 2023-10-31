package com.diamorph.filedata.repository;

import com.diamorph.filedata.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> { }
