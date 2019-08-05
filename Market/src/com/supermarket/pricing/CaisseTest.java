package com.supermarket.pricing;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class CaisseTest {

	private HashMap<String, BigDecimal> tarifs = new HashMap<String, BigDecimal>();

	Caisse caisse;
	{
		tarifs.put("A", new BigDecimal("0.65"));
		tarifs.put("B", new BigDecimal("1.20"));

		caisse = new Caisse (tarifs);
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

}
