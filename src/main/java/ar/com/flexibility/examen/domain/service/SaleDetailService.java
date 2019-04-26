package ar.com.flexibility.examen.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.flexibility.examen.domain.entity.SaleDetail;

@Service
public interface SaleDetailService {

	public abstract List<SaleDetail> listSaleDetails();

	public abstract SaleDetail findById(Long id);

	public abstract SaleDetail save(SaleDetail saleDetail);

	public abstract boolean delete(Long id);

}
