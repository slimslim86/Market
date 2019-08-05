package com.supermarket.pricing;

import java.math.BigDecimal;
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

	private HashMap<String, Tarification> tarifs = new HashMap<String, Tarification>();
	private HashMap<String, Integer> articles = new HashMap<String, Integer>();

	private BigDecimal total = new BigDecimal("0.00");
	
	Tarification tarification = null;

	public Caisse(HashMap<String, Tarification> tarifs) {
		this.tarifs = tarifs;
	}

	void scanner(String produit) {

		if (tarifs.containsKey(produit)) {

			tarification = tarifs.get(produit);

			total = total.add(tarification.getPrix());

			if (tarification.isAvecRemise()) {

				if (articles.containsKey(produit)) {
					articles.put(produit, articles.get(produit) + 1);
				} else {
					articles.put(produit, 1);
				}

				if (articles.get(produit) % tarification.getNombreArticle() == 0) {
					total = total.subtract(tarification.getRemise());


				}
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
