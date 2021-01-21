package com.developer.ads.cellads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.developer.ads.cellads.services.CellPhoneService;

import com.developer.ads.cellads.models.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CellController {
	
	@Autowired
	CellPhoneService cellPhoneService;

	@GetMapping("/cells")
	public List<CellPhone> getCells(@RequestParam(required = false) String id) {
		return  cellPhoneService.getBrands(id);
	}
	
	@GetMapping("/brands")
	public List<Brand> getBrands() {
		return  cellPhoneService.getAllBrands();
	}
}
