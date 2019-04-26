package ar.com.flexibility.examen.domain.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public class SaleModel {

	private BigInteger saleNumber;
	private Long clientId;
	private LocalDate saleDate;
	private List<SaleDetailModel> details;

	public SaleModel() {
	}

	public SaleModel(BigInteger saleNumber, Long clientId, LocalDate saleDate, List<SaleDetailModel> details) {
		super();
		this.saleNumber = saleNumber;
		this.clientId = clientId;
		this.saleDate = saleDate;
		this.details = details;
	}

	public BigInteger getSaleNumber() {
		return saleNumber;
	}

	public void setSaleNumber(BigInteger saleNumber) {
		this.saleNumber = saleNumber;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
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
		return "Sale [saleNumber=" + saleNumber + ", clientId=" + clientId + ", saleDate=" + saleDate + ", details="
				+ details + "]";
	}

}
