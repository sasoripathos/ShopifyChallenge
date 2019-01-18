package com.jerry.inventory;

import static org.hamcrest.Matchers.*;
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
	
	@Test
	public void testGetIllegalArgument() throws Exception {
		mvc.perform(get("/shopify/product?available=3"))
			.andExpect(status().is4xxClientError())
			.andExpect(jsonPath("$.status", is(400)))
			.andExpect(jsonPath("$.reason", containsString("IllegalArgumentException")));
	}
	
	@Test
	public void testGetOneProduct() throws Exception {
		mvc.perform(get("/shopify/product/a"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.title", is("a")))
			.andExpect(jsonPath("$.price", is(100.5)))
			.andExpect(jsonPath("$.inventoryCount", is(100)));
	}
	
	@Test
	public void testGetNotExistProduct() throws Exception {
		mvc.perform(get("/shopify/product/abc"))
			.andExpect(status().is4xxClientError())
			.andExpect(jsonPath("$.status", is(404)))
			.andExpect(jsonPath("$.reason", is("abc is not a product name!")));
	}
	
	@Test
	public void testPurchaseProduct() throws Exception {
		mvc.perform(post("/shopify/purchase?product=b"))
			.andExpect(status().isOk());
		mvc.perform(get("/shopify/product/b"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.inventoryCount", is(199)));
	}
	
	@Test
	public void testPurchaseUnAvailProduct() throws Exception {
		mvc.perform(post("/shopify/purchase?product=e"))
			.andExpect(status().is4xxClientError())
			.andExpect(jsonPath("$.status", is(400)))
			.andExpect(jsonPath("$.reason", is("There is no e avaiable!")));
		mvc.perform(get("/shopify/product/e"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.inventoryCount", is(0)));
	}

}
