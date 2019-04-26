package ar.com.flexibility.examen.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "product_id")
	private Long id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "price")
	private double price;

	@NotNull
	@Column(name = "stock")
	private int stock;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
	private List<SaleDetail> details;

	public Product() {
	}

	public Product(Long id, String name, double price, int stock, List<SaleDetail> details) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<SaleDetail> getDetails() {
		return details;
	}

	public void setDetails(List<SaleDetail> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", details=" + details
				+ "]";
	}

}
