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

import ar.com.flexibility.examen.domain.entity.Customer;
import ar.com.flexibility.examen.domain.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/get-customers")
	public List<Customer> getCustomers() {
		return customerService.listCustomers();
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id") Long id) {
		Optional<Customer> customer = customerService.findById(id);
		return customer.get();
	}

	@PostMapping("/create")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@PutMapping("/update")
	public Customer update(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@DeleteMapping(path = { "/delete/{id}" })
	public boolean delete(@PathVariable("id") Long id) {
		return customerService.delete(id);
	}

}
