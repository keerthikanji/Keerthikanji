package com.mkj.gtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.gtest.entity.Product;

import com.mkj.gtest.service.ProductServices;

@RestController
@RequestMapping("/product")
public class MyWebController {
	
	@Autowired
	ProductServices productService;
	
	public MyWebController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}
	
	@PostMapping("/Product")
	public String addproduct(@RequestBody Product product) 
	{
		
		try {
			return productService.insertProduct(product);
		} catch (Exception e) {
			return "Contact to product care 1800-250-960 or mail us :- product@gmail.com";
		}
	}
	

	@GetMapping("/ProductName/{searchProductname}")
	public Product abc1(@PathVariable String searchProductName)throws Exception
	{
		return  productService.getProductByProductName(searchProductName);
	}
	
	@GetMapping("/category/{searchCategory}")
	public List<Product> abc2(@PathVariable String searchCategory)throws Exception
	{
		return  productService.getAllProductsByCategory(searchCategory);
	}
	
	@GetMapping("/ProductCode/{searchProductCode}")
	public Product abc3(@PathVariable String searchProductCode)throws Exception
	{
		return  productService.getProductByProductCode(searchProductCode);
	}
	
	@GetMapping("/Productdealer/{searchProductdealer}")
	public List<Product> abc4(@PathVariable String searchProductdealer)throws Exception
	{
		return  productService.getProductByDealerName(searchProductdealer);
	}
	
	@GetMapping("/productbycategoryandpriceanddealer")
	public List<Product> productsByCategoryAndPriceRangeAndDealerName(@RequestParam String cat, @RequestParam int p1,
			@RequestParam int p2, @RequestParam String dlr) throws Exception {

		return productService.getProductsByCategoryAndPriceRangeAndDealerName(cat, p1, p2, dlr);
	}
	@GetMapping("/productbycatgoryandpriceandrating")
	public List<Product> productsByCategoryAndPriceAndRating(@RequestParam String cat, @RequestParam int prc, @RequestParam float rate) throws Exception
	{
		return productService.getAllProductsByCategoryAndPriceAndUserRating(cat, prc, rate);

	}
	
}
