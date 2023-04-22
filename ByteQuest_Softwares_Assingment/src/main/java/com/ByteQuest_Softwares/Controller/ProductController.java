package com.ByteQuest_Softwares.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ByteQuest_Softwares.Exeption.ProductException;
import com.ByteQuest_Softwares.Service.ProductServiceImpl;
import com.ByteQuest_Softwares.model.Product;

@RestController
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	
	@PostMapping("/")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product)
	{
		return new ResponseEntity<Product>(productService.addnewProduct(product),HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer productId)throws ProductException
	{
		
		
		return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);	
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProductDetails(){
		return new ResponseEntity<List<Product>>(productService.getAllProduct(),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer id,@RequestBody Product product)throws ProductException{
		
		return new ResponseEntity<Product>(productService.updateProduct(product, id),HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteProductById(Integer id)throws ProductException{
		
		productService.deleteProduct(id);
	}
}
