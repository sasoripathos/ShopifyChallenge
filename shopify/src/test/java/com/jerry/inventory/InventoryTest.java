package com.jerry.inventory;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.jerry.shopify.App;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@AutoConfigureMockMvc
public class InventoryTest {
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void testGetAllProduct() throws Exception {
		mvc.perform(get("/shopify/product"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(6)));
	}
	
	@Test
	public void testGetAvailableProduct() throws Exception {
		mvc.perform(get("/shopify/product?available=true"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(5)));
	}
	
	/*@Test
	public void testPurchaseProduct() throws Exception {
		mvc.perform(get("/shopify/purchase?product=a"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(5)));
		mvc.perform(get("/shopify/purchase?product=a"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(5)));
	}*/

}
