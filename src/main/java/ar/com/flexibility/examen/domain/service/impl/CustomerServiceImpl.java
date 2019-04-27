package ar.com.flexibility.examen.domain.service.impl;

import java.util.List;
import java.util.Optional;

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
	public Optional<Customer> findById(Long id) {
		return customerJpaRepository.findById(id);
	}

	@Override
	public Customer save(Customer customer) {
		return customerJpaRepository.save(customer);
	}

	@Override
	public boolean delete(Long id) {
		Optional<Customer> customer = this.findById(id);
		return (customer.isPresent()) ? true : false;
	}

}
