package com.supermarket.pricing;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

/*

    Prix normal:
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

 */

public class Caisse {

	private HashMap<String, BigDecimal> tarifs = new HashMap<String, BigDecimal>();

	private BigDecimal total = new BigDecimal("0.00");
	private int nb = 0;

	public Caisse (HashMap<String, BigDecimal> tarifs) {
		this.tarifs = tarifs;
	}

	void scanner(String produit) {

		if (tarifs.containsKey(produit)) {

			this.total = this.total.add(tarifs.get(produit));

			if ((produit).equals("A")) {
				nb++;

				if (nb == 3)
					this.total = this.total.subtract(new BigDecimal("0.95"));

			}
		}

	}

	BigDecimal getTotalFinale() {

		return this.total;

	}

	void scannerPlusieurProduit(String produits) {

		produits.chars().forEach(c -> scanner((char) c + ""));

	}
	
	
 
}
