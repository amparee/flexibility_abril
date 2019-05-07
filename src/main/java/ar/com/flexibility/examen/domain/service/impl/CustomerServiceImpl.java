package ar.com.flexibility.examen.domain.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.flexibility.examen.domain.entity.Customer;
import ar.com.flexibility.examen.domain.repository.CustomerJpaRepository;
import ar.com.flexibility.examen.domain.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerJpaRepository customerJpaRepository;

	private final Log LOG = LogFactory.getLog(CustomerServiceImpl.class);

	@Override
	public List<Customer> listCustomers() {
		return customerJpaRepository.findAll();
	}

	@Override
	public Customer findById(Long id) throws NoSuchElementException {
		return customerJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Customer doesn't exist with id: " + id));
	}

	@Override
	public Customer save(Customer customer) {
		return customerJpaRepository.save(customer);
	}

	@Override
	public boolean delete(Long id) {
		Customer customer = customerJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Customer doesn't exist with id: " + id));
		return (customer != null) ? true : false;
	}

}
