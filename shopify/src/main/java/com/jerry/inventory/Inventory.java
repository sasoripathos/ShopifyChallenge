package com.jerry.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopify")
public class Inventory {
	
	private static List<Product> archive = new ArrayList<Product>() {
		private static final long serialVersionUID = -3208985187141932011L;
		
		{
			add(new Product("a", 100.50, 5));
			add(new Product("b", 100.50, 3));
			add(new Product("c", 100.50, 0));
		}
	};
	
	@GetMapping("product")
	public List<Product> getAllProduct(@RequestParam(value="available", defaultValue="false") Boolean avail) {
		if (avail) {
			List<Product> result = new ArrayList<>();
			for (Product i: archive) {
				if(i.available()) {
					result.add(i);
				}
			}
			return result;
		}
		else {
			return archive;
		}
	}
	
}
