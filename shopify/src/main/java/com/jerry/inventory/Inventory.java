package com.jerry.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jerry.exception.ProductNotAvailableException;
import com.jerry.exception.ProductNotExistException;

@RestController
@RequestMapping("/shopify")
public class Inventory {
	
	private static List<Product> archive = new ArrayList<Product>() {
		private static final long serialVersionUID = -3208985187141932011L;
		
		{
			add(new Product("a", 100.50, 100));
			add(new Product("b", 56.50, 200));
			add(new Product("c", 70000.50, 3));
			add(new Product("d", 5.78, 5));
			add(new Product("e", 15.25, 0));
			add(new Product("f", 5000.45, 75));
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
	
	@PostMapping("purchase")
	public void purchase(@RequestParam(value="product", required=true) String name)
			throws ProductNotAvailableException, ProductNotExistException {
		Product pd = null;
		for(Product i:archive) {
			if(i.getTitle().equals(name)) {
				pd = i;
				break;
			}
		}
		if(pd == null) {
			throw new ProductNotExistException(name + " is not a product name!");
		} else {
			pd.purchase();
		}
	}
	
}
