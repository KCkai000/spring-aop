package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.aop.CartService;


@SpringBootTest
public class AOPCartTest {
	
	@Autowired
	private CartService cartService;
	
	@Test
	public void Test() {
		String productId = "001";
		Integer quantity = 25;
		Double price = 25.5;
		
		try {
			cartService.addToCart(productId, quantity, price);
		}catch(Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}
