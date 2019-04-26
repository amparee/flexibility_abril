package ar.com.flexibility.examen.app.rest;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.flexibility.examen.domain.entity.Product;
import ar.com.flexibility.examen.domain.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	public ClienteRestController(CustomerServiceImpl customerService) {
		this.customerService = customerService
	}

	@GetMapping("/getclientes")
	public Collection<Product> getClientes() {
		return clienteService.listarClientes();
	}

	@GetMapping("/{id}")
	public Product getCanales(@PathVariable("id") Long id) {
		return clienteService.findById(id);
	}

	@PostMapping("/nuevocliente")
	public Product create(@RequestBody Product cliente) {

		return cliente;

	}

	@PutMapping
	public Product update(@RequestBody Product cliente) {

		return clienteActualizar;
	}

	@DeleteMapping(path = { "/delete/{id}" })
	public Product delete(@PathVariable("id") Long id) {

		return cliente;
	}

}
