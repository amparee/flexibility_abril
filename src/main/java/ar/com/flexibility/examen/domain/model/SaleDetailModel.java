package ar.com.flexibility.examen.domain.model;

public class SaleDetailModel {

	private Long saleId;
	private Long productId;
	private int quantity;
	private double price;

	public SaleDetailModel() {
	}

	public SaleDetailModel(Long saleId, Long productId, int quantity, double price) {
		this.saleId = saleId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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
		return "SaleDetailModel [saleId=" + saleId + ", productId=" + productId + ", quantity=" + quantity + ", price="
				+ price + "]";
	}

}
