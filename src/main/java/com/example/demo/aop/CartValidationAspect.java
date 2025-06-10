package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CartValidationAspect {
	
	@Before(value =  "execution(* com.example.demo.aop.CartService.addToCart(..))")
	public void validateCartParma(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		String productId = (String)args[0];
		Integer quantity = (int)args[1];
		Double price = (double)args[2];
		
		// 商品 Id 不可以為 null
		if(productId == null || productId.isBlank()) {
			throw new IllegalArgumentException("商品 ID 不得為空");
		}
		
		// 數量必須介於1 ~ 100間
		if(quantity<=0 || quantity >=100) {
			throw new IllegalArgumentException("數量必須介於1 ~ 100間");
		}
		
		//價格必須大於0
		if(price<0) {
			throw new IllegalArgumentException("價格必須大於0");
		}
	}
}
