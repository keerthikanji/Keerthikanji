package com.mkj.gtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.gtest.entity.Product;

import com.mkj.gtest.repository.ProductRepository;

@Service

public class ProductServicesImpl implements ProductServices {
    
	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	public List<Product> getAllProducts() throws Exception {
		// TODO Auto-generated method stub
		List<Product> allproducts =productRepository.findAll();
		
		return allproducts;
	}

	@Override
	public String insertProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		Product savedProduct =  productRepository.save(product);  // Note :  save() is already implemented by Spring Data JPA
		if(savedProduct != null)
		{
			return "Product  Saved "+product.getProductName()+" productname :- "+product.getProductName();
		}
		else return null;
		
	}

	@Override
	public Product getProductByProductName(String ProductName) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getProductByProductName(ProductName);
		}

	@Override
	public List<Product> getAllProductsByCategory(String Category) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getAllProductsByCategory(Category);
	}

	@Override
	public Product getProductByProductCode(String ProductCode) {
		// TODO Auto-generated method stub
		return productRepository.getProductByProductCode(ProductCode);
	}

	

	@Override
	public List<Product> getProductsByCategoryAndPriceRangeAndDealerName(String category, int price1, int price2,
			String dealerName) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getProductsByCategoryAndPriceRangeAndDealerName(category, price1, price2, dealerName);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPriceAndUserRating(String category, int price, float userRating)
			throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getAllProductsByCategoryAndPriceAndUserRating(category, price, userRating);
	}

	@Override
	public List<Product> getProductByDealerName(String dealerName) {
		// TODO Auto-generated method stub
		return productRepository.getProductByDealerName(dealerName);
	}

	

	

	
	
}



