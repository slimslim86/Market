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
		
		System.out.println(caisse.getTotalFinale());
		org.junit.Assert.assertEquals(new BigDecimal("0.00"),caisse.getTotalFinale());
	}
	
	
	@Test
	void unProduit(){

		caisse.scanner("A");
		System.out.println(caisse.getTotalFinale());

		org.junit.Assert.assertEquals(new BigDecimal("0.65"),caisse.getTotalFinale());
		
	}

}
