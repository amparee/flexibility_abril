package ar.com.flexibility.examen.domain.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.flexibility.examen.domain.entity.SaleDetail;
import ar.com.flexibility.examen.domain.repository.SaleDetailJpaRepository;
import ar.com.flexibility.examen.domain.service.SaleDetailService;

@Service
public class SaleDetailServiceImpl implements SaleDetailService {

	@Autowired
	private SaleDetailJpaRepository saleDetailJpaRepository;

	private final Log LOG = LogFactory.getLog(SaleDetailServiceImpl.class);

	@Override
	public List<SaleDetail> listSaleDetails() {
		return saleDetailJpaRepository.findAll();
	}

	@Override
	public SaleDetail findById(Long id) throws NoSuchElementException {
		return saleDetailJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("SaleDetail doesn't exist with id: " + id));
	}

	@Override
	public SaleDetail save(SaleDetail saleDetail) {
		return saleDetailJpaRepository.save(saleDetail);
	}

	@Override
	public boolean delete(Long id) {
		SaleDetail saleDetail = saleDetailJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("SaleDetail doesn't exist with id: " + id));
		return (saleDetail != null) ? true : false;
	}

}
