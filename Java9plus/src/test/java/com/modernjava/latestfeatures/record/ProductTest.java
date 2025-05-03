package com.modernjava.latestfeatures.record;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductTest {

	@Test
	public void createProduct() {
		// given
		var product = new Product("iPhone", new BigDecimal("99.99"), "ELECTRONICS");

		// when
		System.out.println("Product : " + product);
		assertEquals("iPhone", product.name());
		assertEquals("ELECTRONICS", product.type());

		// then

	}

	@Test
	public void createProductCustom() {
		// given
		var product = new Product("iPhone", new BigDecimal("99.99"));

		// when
		System.out.println("Product : " + product);
		assertEquals("iPhone", product.name());
		assertEquals("GENERAL", product.type());

		// then

	}

	@Test
	public void createProduct_invalidName() {
		// given
		// when

		var exception = assertThrows(IllegalArgumentException.class,
				() -> new Product("", new BigDecimal("99.99"), "ELECTRONICS"));

		// then
		assertEquals("name is not valid", exception.getMessage());
	}

	@Test
	public void createProduct_invalidCost() {
		// given
		// when

		var exception = assertThrows(IllegalArgumentException.class,
				() -> new Product("iPhone", BigDecimal.ZERO, "ELECTRONICS"));

		// then
		assertEquals("cost is not valid", exception.getMessage());
	}

	@Test
	public void testProductComparison() {
		// given
		var product1 = new Product("iPhone", new BigDecimal("99.99"), "ELECTRONICS");
		var product2 = new Product("iPhone", new BigDecimal("99.99"), "ELECTRONICS");
		
		assertEquals(product1, product2);
	}

}