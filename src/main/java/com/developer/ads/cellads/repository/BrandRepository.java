package com.developer.ads.cellads.repository;

import java.util.List;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.developer.ads.cellads.models.*;


@Repository
public interface BrandRepository extends ElasticsearchRepository<Brand, String> {

   // Page<CellPhone> findByBrand(String name);

	
	
	List<Brand> findAll();
}