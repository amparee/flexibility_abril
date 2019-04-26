package ar.com.flexibility.examen.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class SaleDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "sale_detail_id")
	private Long id;

	@JoinColumn(name = "sale", referencedColumnName = "sale_id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Sale sale;

	@JoinColumn(name = "product", referencedColumnName = "product_id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Product product;

	@NotNull
	@Column(name = "quantity")
	private int quantity;

	@NotNull
	@Column(name = "price")
	private double price;

	public SaleDetail() {
	}

	public SaleDetail(Long id, Sale sale, Product product, int quantity, double price) {
		this.id = id;
		this.sale = sale;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SaleDetail [id=" + id + ", sale=" + sale + ", product=" + product + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

}
