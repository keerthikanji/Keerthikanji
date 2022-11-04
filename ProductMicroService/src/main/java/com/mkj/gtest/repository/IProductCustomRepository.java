package com.mkj.gtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mkj.gtest.entity.Product;

public interface IProductCustomRepository {

	public Product getProductByProductName(String ProductName)throws Exception;
	
	public List<Product> getAllProductsByCategory(String Category)throws Exception;
	
	public Product getProductByProductCode(String ProductCode);
	
	public List<Product> getProductByDealerName(String dealerName);
	
	@Query("from Product where category = :category and price >= :price1 and price <= :price2 and dealerName =:dealerName")
	public List<Product> getProductsByCategoryAndPriceRangeAndDealerName(@Param ("category")String category , @Param("price1") int price1,@Param("price2") int price2,@Param("dealer") String dealerName) throws Exception;
	public List<Product> getAllProductsByDealerName(String dealerName) throws Exception;
	@Query("from Product where category =:category and price = :price and Userrating =:Userrating")
	public List<Product> getAllProductsByCategoryAndPriceAndUserRating(@Param("category")String category, @Param("price")int price, @Param("Userrating")float Userrating) throws Exception;

	
}