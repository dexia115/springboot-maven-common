package com.gaia.utils.mail;

public class SimpleTest {
	
	public static void main(String[] args){
		ProductPriceObserver oo = new ProductPriceObserver();
		oo.update(null, 1000f);
		System.out.println("OK");
	}

}
