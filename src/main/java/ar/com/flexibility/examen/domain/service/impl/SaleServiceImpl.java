package ar.com.flexibility.examen.domain.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.flexibility.examen.domain.entity.Sale;
import ar.com.flexibility.examen.domain.repository.SaleJpaRepository;
import ar.com.flexibility.examen.domain.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleJpaRepository saleJpaRepository;

	private final Log LOG = LogFactory.getLog(SaleServiceImpl.class);

	@Override
	public List<Sale> listSales() {
		return saleJpaRepository.findAll();
	}

	@Override
	public Sale findById(Long id) throws NoSuchElementException {
		return saleJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Sale doesn't exist with id: " + id));

	}

	@Override
	public Sale save(Sale sale) {
		return saleJpaRepository.save(sale);
	}

	@Override
	public boolean delete(Long id) {
		Sale sale = saleJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Sale doesn't exist with id: " + id));
		if (sale != null) {
			saleJpaRepository.delete(sale);
			return true;
		} else {
			return false;
		}

	}

}
