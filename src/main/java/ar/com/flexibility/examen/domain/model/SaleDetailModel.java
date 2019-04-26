package ar.com.flexibility.examen.domain.model;

import ar.com.flexibility.examen.domain.entity.Product;
import ar.com.flexibility.examen.domain.entity.Sale;

public class SaleDetailModel {

	private Sale sale;
	private Product product;
	private int quantity;
	private double price;

	public SaleDetailModel() {
	}

	public SaleDetailModel(Sale sale, Product product, int quantity, double price) {
		this.sale = sale;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
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
		return "SaleDetailModel [sale=" + sale + ", product=" + product + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}

}
