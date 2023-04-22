package com.ByteQuest_Softwares.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ByteQuest_Softwares.Exeption.ProductException;
import com.ByteQuest_Softwares.Repository.ProductRepository;
import com.ByteQuest_Softwares.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productrepository;
	
	
	
	
	@Override
	public Product addnewProduct(Product product) {
		
		Product newproduct=productrepository.save(product);
		
		return newproduct;
	}

	@Override
	public void deleteProduct(Integer id) throws ProductException {

		Optional<Product> opt=productrepository.findById(id);
		
		if(opt.isEmpty())
		{
			throw new ProductException("Product is not there with this Id : "+id);
		}
		
		productrepository.delete(opt.get());
		
	}

	@Override
	public List<Product> getAllProduct() {
		return productrepository.findAll();
		
	}
	@Override
	public Product getProductById(Integer id)throws ProductException{
		Optional<Product> opt=productrepository.findById(id);
		
		if(opt.isEmpty())
		{
			throw new ProductException("Product is not there with this Id : "+id);
		}
		return opt.get();
		
		
		
	}

	@Override
	public Product updateProduct(Product product, Integer id) throws ProductException {
			Optional<Product> opt=productrepository.findById(id);
		
			if(opt.isEmpty())
			{
				throw new ProductException("Product is not there with this Id : "+id);
			}
			
			Product newproduct=opt.get();
			newproduct.setName(product.getName());
			newproduct.setDescribtion(product.getDescribtion());
			newproduct.setImageurl(product.getImageurl());
			newproduct.setPrice(product.getPrice());
			newproduct.setQuantity(product.getQuantity());
			newproduct.setType(product.getType());
			
			productrepository.save(newproduct);
			
		return newproduct;
	}

}
