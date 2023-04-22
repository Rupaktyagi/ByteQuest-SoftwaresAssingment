package com.ByteQuest_Softwares.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@NonNull
	private String name;
	
	@NonNull
	private String describtion;
	
	@NonNull
	private String type;
	
	@NonNull
	private Integer quantity;
	
	@NonNull
	private double price;
	
	@NonNull
	private String imageurl;
	
}
