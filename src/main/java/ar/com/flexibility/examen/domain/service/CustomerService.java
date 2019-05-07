package ar.com.flexibility.examen.domain.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import ar.com.flexibility.examen.domain.entity.Customer;

@Service
public interface CustomerService {

	public abstract List<Customer> listCustomers();

	public abstract Customer findById(Long id) throws NoSuchElementException;

	public abstract Customer save(Customer customer);

	public abstract boolean delete(Long id);

}
