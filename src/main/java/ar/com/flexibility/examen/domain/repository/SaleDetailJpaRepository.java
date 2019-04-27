package ar.com.flexibility.examen.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.flexibility.examen.domain.entity.SaleDetail;

@Repository
public interface SaleDetailJpaRepository extends JpaRepository<SaleDetail, Long> {

	public List<SaleDetail> findAll();

	public Optional<SaleDetail> findById(Long id);

	public SaleDetail save(SaleDetail saleDetail);

	public void delete(SaleDetail saleDetail);

}
