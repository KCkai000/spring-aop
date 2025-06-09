package com.example.demo.proxy;

public class CalcProxy implements Calc{
	
	private Calc calc;
	
	public CalcProxy(Calc calc) {
		this.calc = calc;
	}
	
	@Override
	public Integer add(Integer x, Integer y) {
		// 前置通知：驗證 x, y 不可以是null
		if(x ==null || y == null) {
			System.out.println("x , y請輸入數字");
			return null;
		}
		//調用業務邏輯
		Integer result =  calc.add(x,y);		
		return result;
	}

	@Override
	public Integer div(Integer x, Integer y) {
//		// 前置通知：驗證 x, y 不可以是null
//		if(x == null || y == null) {
//			System.out.println("x , y請輸入數字");
//			return null;
//		}else if (y == 0) {
//			System.out.println("分母 y 不得為0");
//			return null;
//		}
//		Integer result = calc.div(x,y);	
//		return result;	
		
		// 前置通知：驗證 x, y 不可以是null
		Integer result = null;
		if(x ==null || y == null) {
			System.out.println("x , y請輸入數字");
			return null;
		}
		//調用業務邏輯
		try {
			result =  calc.div(x,y);				
		}catch(ArithmeticException e) {
			//例外通知
			System.out.println("分母 y 不可 = 0, " + e.getMessage());
		}finally {
			System.out.println("計算完成");
		}
		return result;
	}

}
