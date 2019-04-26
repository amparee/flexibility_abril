package ar.com.flexibility.examen.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.flexibility.examen.domain.entity.Customer;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {

	public List<Customer> findAll();

	public Optional<Customer> findById(Long id);

	public Customer save(Customer customer);

	public void delete(Customer customer);

}
