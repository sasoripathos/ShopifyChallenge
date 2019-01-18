package com.jerry.inventory;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jerry.exception.ProductNotAvailableException;

public class ProductTest {

	@Test
	public void testConstructor() {
		Product a = new Product("a", 100.5, 5);
		assertTrue(a!=null);
		assertTrue(a instanceof Product);
	}
	
	@Test
	public void testTitle() {
		Product a = new Product("a", 100.5, 5);
		assertEquals("a", a.getTitle());
		a.setTitle("abc");
		assertEquals("abc", a.getTitle());
	}
	
	@Test
	public void testPrice() {
		Product a = new Product("a", 100.5, 5);
		assertEquals(100.5, a.getPrice(), 0.001);
		a.setPrice(200.78);
		assertEquals(200.78, a.getPrice(), 0.001);
	}
	
	@Test
	public void testInventoryCount() {
		Product a = new Product("a", 100.5, 5);
		assertEquals(5, a.getInventoryCount().intValue());
		a.setInventoryCount(6);
		assertEquals(6, a.getInventoryCount().intValue());
	}
	
	@Test
	public void testAvaiable() {
		Product a = new Product("a", 100.5, 0);
		assertFalse(a.available());
		a.setInventoryCount(5);
		assertTrue(a.available());
	}
	
	@Test
	public void testPurchase() throws ProductNotAvailableException {
		Product a = new Product("a", 100.5, 5);
		assertEquals(5, a.getInventoryCount().intValue());
		a.purchase();
		assertEquals(4, a.getInventoryCount().intValue());
	}
	
	@Test(expected = ProductNotAvailableException.class)
	public void testCannotPurchase() throws ProductNotAvailableException {
		Product a = new Product("a", 100.5, 0);
		a.purchase();
	}

}
