package ar.com.flexibility.examen.app.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.flexibility.examen.domain.entity.Product;
import ar.com.flexibility.examen.domain.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@GetMapping("/get-products")
	public List<Product> getProducts() {
		return productService.listProducts();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		Optional<Product> product = productService.findById(id);
		return product.get();
	}

	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
		return productService.save(product);
	}

	@PutMapping("/update")
	public Product update(@RequestBody Product product) {
		return productService.save(product);
	}

	@DeleteMapping(path = { "/delete/{id}" })
	public boolean delete(@PathVariable("id") Long id) {
		return productService.delete(id);
	}

}
