package ar.com.flexibility.examen.domain.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import ar.com.flexibility.examen.domain.entity.Customer;

public class SaleModel {

	private BigInteger saleNumber;
	private Customer customerId;
	private LocalDate saleDate;
	private List<SaleDetailModel> details;

	public SaleModel() {
	}

	public SaleModel(BigInteger saleNumber, Customer customerId, LocalDate saleDate, List<SaleDetailModel> details) {
		this.saleNumber = saleNumber;
		this.customerId = customerId;
		this.saleDate = saleDate;
		this.details = details;
	}

	public BigInteger getSaleNumber() {
		return saleNumber;
	}

	public void setSaleNumber(BigInteger saleNumber) {
		this.saleNumber = saleNumber;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

	public List<SaleDetailModel> getDetails() {
		return details;
	}

	public void setDetails(List<SaleDetailModel> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "SaleModel [saleNumber=" + saleNumber + ", customerId=" + customerId + ", saleDate=" + saleDate
				+ ", details=" + details + "]";
	}

}
