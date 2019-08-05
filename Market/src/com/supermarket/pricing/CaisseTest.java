package com.supermarket.pricing;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class CaisseTest {

	private HashMap<String, BigDecimal> tarifs = new HashMap<String, BigDecimal>();

	Caisse caisse;
	{
		tarifs.put("A", new BigDecimal("0.65"));
		tarifs.put("B", new BigDecimal("1.20"));
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

}
