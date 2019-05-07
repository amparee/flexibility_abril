package ar.com.flexibility.examen.app.rest;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Product>> getProducts() {
		return new ResponseEntity<List<Product>>(productService.listProducts(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {

		try {
			Product product = productService.findById(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.save(product), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Product> update(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.save(product), HttpStatus.OK);
	}

	@DeleteMapping(path = { "/delete/{id}" })
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		boolean deleted = productService.delete(id);

		if (deleted) {
			return new ResponseEntity<String>("Product with id:" + id + " has been deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Product with id:" + id + " has not been deleted",
					HttpStatus.METHOD_NOT_ALLOWED);
		}
	}

}
