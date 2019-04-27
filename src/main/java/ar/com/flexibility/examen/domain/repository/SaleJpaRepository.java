package ar.com.flexibility.examen.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.flexibility.examen.domain.entity.Sale;

@Repository
public interface SaleJpaRepository extends JpaRepository<Sale, Long> {

	public List<Sale> findAll();

	public Optional<Sale> findById(Long id);

	public Sale save(Sale sale);

	public void delete(Sale sale);

}
