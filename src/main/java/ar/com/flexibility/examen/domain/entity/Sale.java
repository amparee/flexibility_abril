package ar.com.flexibility.examen.domain.entity;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import ar.com.flexibility.examen.domain.model.SaleDetailModel;

public class Sale {

	private BigInteger saleNumber;
	private Customer customerId;
	private LocalDate saleDate;
	private List<SaleDetailModel> details;

}
