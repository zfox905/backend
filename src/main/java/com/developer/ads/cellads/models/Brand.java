package com.developer.ads.cellads.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "brands")
public class Brand {
	
	  @Id
	  private String id;
	  
	  @Field(type = FieldType.Text, name = "brand")
	  private String brand;
	  
	  public String getBrand() {
		  return brand;
		  
	  }
	  

}
