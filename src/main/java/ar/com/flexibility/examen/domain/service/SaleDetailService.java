package ar.com.flexibility.examen.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.com.flexibility.examen.domain.entity.SaleDetail;

@Service
public interface SaleDetailService {

	public abstract List<SaleDetail> listSaleDetails();

	public abstract Optional<SaleDetail> findById(Long id);

	public abstract SaleDetail save(SaleDetail saleDetail);

	public abstract boolean delete(Long id);

}
