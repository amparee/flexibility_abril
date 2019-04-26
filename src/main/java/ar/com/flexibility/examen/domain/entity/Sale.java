package ar.com.flexibility.examen.domain.entity;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "sale_id")
	private Long id;

	@NotNull
	@Column(name = "sale_number")
	private BigInteger saleNumber;

	@JoinColumn(name = "customer", referencedColumnName = "customer_id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Customer customer;

	@NotNull
	@Column(name = "sale_date")
	private LocalDate saleDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.EAGER)
	private List<SaleDetail> details;

	public Sale() {
	}

	public Sale(Long id, BigInteger saleNumber, Customer customer, LocalDate saleDate, List<SaleDetail> details) {
		this.id = id;
		this.saleNumber = saleNumber;
		this.customer = customer;
		this.saleDate = saleDate;
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigInteger getSaleNumber() {
		return saleNumber;
	}

	public void setSaleNumber(BigInteger saleNumber) {
		this.saleNumber = saleNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

	public List<SaleDetail> getDetails() {
		return details;
	}

	public void setDetails(List<SaleDetail> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", saleNumber=" + saleNumber + ", customer=" + customer + ", saleDate=" + saleDate
				+ ", details=" + details + "]";
	}

}
