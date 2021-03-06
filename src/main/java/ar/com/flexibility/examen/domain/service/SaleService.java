package ar.com.flexibility.examen.domain.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import ar.com.flexibility.examen.domain.entity.Sale;

@Service
public interface SaleService {

	public abstract List<Sale> listSales();

	public abstract Sale findById(Long id) throws NoSuchElementException;

	public abstract Sale save(Sale sale);

	public abstract boolean delete(Long id);

}
