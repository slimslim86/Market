package com.supermarket.pricing;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class CaisseTest {

	private HashMap<String, Tarification> tarifs = new HashMap<String, Tarification>();

	Caisse caisse;
	{
		//Tarification (prix,avec remise,montant remise,nombre d'articles pour avoir une remise)
		
		tarifs.put("A", new Tarification(new BigDecimal("0.65"), true,new BigDecimal ("0.95"), 3));
		tarifs.put("B", new Tarification(new BigDecimal("1.2"), true, new BigDecimal("0.4"), 2));
		caisse = new Caisse(tarifs);
	}
	@Test
	void zeroProduit() {

		org.junit.Assert.assertEquals(new BigDecimal("0.00"), caisse.getTotalFinale());
	}

	@Test
	void unProduit() {

		caisse.scanner("A");

		org.junit.Assert.assertEquals(new BigDecimal("0.65"), caisse.getTotalFinale());

	}

	@Test
	void deuxProduitDifferent() {
		caisse.scannerPlusieurProduit("AB");

		org.junit.Assert.assertEquals(new BigDecimal("1.85"), caisse.getTotalFinale());

	}

	@Test
	void troisProduitIdentiques() {

		caisse.scannerPlusieurProduit("AAA");
 
		org.junit.Assert.assertEquals(new BigDecimal("1.00"), caisse.getTotalFinale());
	}

	@Test
	void sixProduitIdentiques() {
		caisse.scannerPlusieurProduit("AAAAAA");

		org.junit.Assert.assertEquals(new BigDecimal("2.00"),caisse.getTotalFinale());
	}

	@Test
	void troisproduitAEtDeuxProduitB() {
		caisse.scannerPlusieurProduit("AAABB");

		org.junit.Assert.assertEquals(new BigDecimal("3.00"),caisse.getTotalFinale());
	}

	@Test
	void quatreProduitIdentiques() {
		caisse.scannerPlusieurProduit("AAAA");

 		org.junit.Assert.assertEquals(new BigDecimal("1.65"),caisse.getTotalFinale());

	}

}
