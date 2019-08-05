package com.supermarket.pricing;

import java.math.BigDecimal;

/*
 * 
 * 
 *  Prix normal:
		A -> 0.65
		B->1.2
	
	Prix special:
		AAA -> 1
		BB-> 2

	Ex:
	AAAA-> 1+0.65
	AAAAA -> 1+0.65+0.65
	AAAAAA-> 2
	AAABB->3

 * 
 * 
 * 
 */

public class Caisse {
	
	void scanner(String produit){

	}

	BigDecimal total (){
	return new BigDecimal("0.00");

	}
	
}
