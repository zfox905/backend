package com.developer.ads.cellads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.developer.ads.cellads.repository.CellPhoneRepository;

@SpringBootApplication
public class CelladsApplication {
	
	

	public static void main(String[] args) {
		
		SpringApplication.run(CelladsApplication.class, args);
	}

}
