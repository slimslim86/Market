package com.supermarket.pricing;

 

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class CaisseTest {
	
	Caisse caisse;
	{
		caisse= new Caisse();
	}

	@Test
	void zeroProduit(){
		
		System.out.println(caisse.total());
		org.junit.Assert.assertEquals(new BigDecimal("0.00"),caisse.total());
 
	}

}
