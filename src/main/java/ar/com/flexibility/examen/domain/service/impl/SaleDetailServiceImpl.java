package ar.com.flexibility.examen.domain.service.impl;

import java.util.List;
import java.util.Optional;

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
	public Optional<SaleDetail> findById(Long id) {
		return saleDetailJpaRepository.findById(id);
	}

	@Override
	public SaleDetail save(SaleDetail saleDetail) {
		return saleDetailJpaRepository.save(saleDetail);
	}

	@Override
	public boolean delete(Long id) {
		Optional<SaleDetail> saleDetail = saleDetailJpaRepository.findById(id);
		return (saleDetail.isPresent()) ? true : false;
	}

}
