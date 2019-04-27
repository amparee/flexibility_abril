package ar.com.flexibility.examen.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.com.flexibility.examen.domain.entity.Customer;

@Service
public interface CustomerService {

	public abstract List<Customer> listCustomers();

	public abstract Optional<Customer> findById(Long id);

	public abstract Customer save(Customer customer);

	public abstract boolean delete(Long id);

}
