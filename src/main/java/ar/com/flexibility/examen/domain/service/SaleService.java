package ar.com.flexibility.examen.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.com.flexibility.examen.domain.entity.Sale;

@Service
public interface SaleService {

	public abstract List<Sale> listSales();

	public abstract Optional<Sale> findById(Long id);

	public abstract Sale save(Sale sale);

	public abstract boolean delete(Long id);

}
