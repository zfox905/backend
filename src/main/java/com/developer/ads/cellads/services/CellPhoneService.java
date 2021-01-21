package com.developer.ads.cellads.services;

import com.developer.ads.cellads.models.*;
import com.developer.ads.cellads.repository.BrandRepository;
import com.developer.ads.cellads.repository.CellPhoneRepository;

import java.util.List;


import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.*;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Component
public class CellPhoneService {
	
	@Autowired CellPhoneRepository cellPhoneRepository;
	@Autowired BrandRepository brandRepository;
	
	
	
	public List<CellPhone> getBrands(String brand) {
		return(List<CellPhone>) cellPhoneRepository.findByBrand(brand);
	}
	
	public List<Brand> getAllBrands() {
		return(List<Brand>) brandRepository.findAll();
	}

}

