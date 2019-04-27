package ar.com.flexibility.examen.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.flexibility.examen.domain.entity.Product;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Long> {

	public List<Product> findAll();

	public Optional<Product> findById(Long id);

	public Product save(Product product);

	public void delete(Product product);

}
