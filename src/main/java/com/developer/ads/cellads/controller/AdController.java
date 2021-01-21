package com.developer.ads.cellads.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.developer.ads.cellads.repository.*;
import com.developer.ads.cellads.models.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AdController {
	
	@Autowired
	AdRepository adRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	@GetMapping("/ads")
	public ResponseEntity<List<Ad>> getAllAds(@RequestParam(required = false) String title) {
		try {
		      List<Ad> ads = new ArrayList<Ad>();

		      if (title == null)
		        adRepository.findAll().forEach(ads::add);
		      else
		    	  adRepository.findByTitleContaining(title).forEach(ads::add);

		      if (ads.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(ads, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	  @PostMapping("/ads")
	  public ResponseEntity<Ad> createAdd(@RequestBody @Valid Ad ad, @RequestBody @Valid String s) {
		
		  Optional<User> optionalUser = userRepository.findByUsername(ad.getUser().getUsername());
		if (!optionalUser.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		ad.setUser(optionalUser.get());
		  
		  
	    try {
	      Ad _ad = adRepository.save(ad);
	      return new ResponseEntity<>(_ad, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
