package com.developer.ads.cellads.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.developer.ads.cellads.models.*;

public interface AdRepository extends JpaRepository<Ad, Long> {
	List<Ad> findByTitleContaining(String title);
}
