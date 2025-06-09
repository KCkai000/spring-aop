package com.example.demo.proxy;


public class DynProxyTest {
	
	public static void main(String[] args) {
		//動態代理測試
		DynProxy dynProxy = new DynProxy(new CalcImpl());
		//取得代理物件
		Calc calc = (Calc)dynProxy.getProxy();
		System.out.println(calc.div(10,20));
		System.out.println(calc.div(null,20));
		System.out.println(calc.div(20,0));
		
		//---------------------------------------
		DynProxy dynProxy2 = new DynProxy(new Man());
		Person man = (Person)dynProxy2.getProxy();
		man.work();
	}
}
