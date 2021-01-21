package com.developer.ads.cellads.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "cellphones")
public class CellPhone {
  @Id
  private String id;
  
  @Field(type = FieldType.Text, name = "Announced")
  private String announced;
  
  @Field(type = FieldType.Text, name = "Brand")
  private String brand;
  
  @Field(type = FieldType.Text, name = "Phone")
  private String phone;
  
  @Field(type = FieldType.Text, name = "ID")
  private int ID;
  
  @Field(type = FieldType.Text, name = "Picture URL small")
  private String smallpic;
  
  public String getBrand() {
	  return brand;
	  
  }
  
  public String getAnnounced() {
	  return announced; 
  }
  
  public String getSmallpic() {
	  return smallpic; 
  }
  
  public String getPhone() {
	  return phone; 
  }
 
  public int getID() {
	  return ID; 
  }
  
}
