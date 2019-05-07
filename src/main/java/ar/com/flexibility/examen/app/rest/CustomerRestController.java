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

import ar.com.flexibility.examen.domain.entity.Customer;
import ar.com.flexibility.examen.domain.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/get-customers")
	public ResponseEntity<List<Customer>> getCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.listCustomers(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id) {

		try {
			Customer customer = customerService.findById(id);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.save(customer), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Customer> update(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.save(customer), HttpStatus.OK);
	}

	@DeleteMapping(path = { "/delete/{id}" })
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		boolean deleted = customerService.delete(id);

		if (deleted) {
			return new ResponseEntity<String>("Customer with id:" + id + " has been deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Customer with id:" + id + " has not been deleted",
					HttpStatus.METHOD_NOT_ALLOWED);
		}

	}

}
