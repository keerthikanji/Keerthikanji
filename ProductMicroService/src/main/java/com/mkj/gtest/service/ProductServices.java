package com.mkj.gtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkj.gtest.entity.Product;




@Service
public interface ProductServices {

	
	
	public List<Product>getAllProducts()throws Exception;
	
	
	public  String insertProduct(Product product)throws Exception;
	
	 public Product getProductByProductName(String ProductName) throws Exception;

	public Product getProductByProductCode(String searchProductCode);
	
	public List<Product> getAllProductsByCategory(String Category) throws Exception;

	public List<Product> getProductByDealerName(String dealerName);
	public List<Product> getProductsByCategoryAndPriceRangeAndDealerName(String category ,int price1, int price2 , String dealerName) throws Exception;
	
	public List<Product> getAllProductsByCategoryAndPriceAndUserRating(String category, int price, float userRating) throws Exception;

	

}
