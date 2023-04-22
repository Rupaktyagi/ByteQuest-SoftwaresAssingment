package com.ByteQuest_Softwares.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ByteQuest_Softwares.Exeption.ProductException;
import com.ByteQuest_Softwares.model.Product;

@Service
public interface ProductService {

	public Product addnewProduct(Product product);	

	public void deleteProduct(Integer id)throws ProductException;
	
	public Product getProductById(Integer id)throws ProductException;
  
	public List<Product> getAllProduct();
  
	public Product updateProduct(Product product,Integer id)throws ProductException;
  
  
  
}
