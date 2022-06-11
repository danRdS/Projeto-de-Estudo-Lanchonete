package entities;

public class Pedido {
	private int id;
	private String product;
	private double price;
	
	public Pedido(int id, String product, double price) {
		this.id = id;
		this.product = product;
		this.price = price;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getProduct() {
		return product;
	}
	
	public void setProduct(String product) {
		this.product = product;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return "Código: "
				+ id
				+ ", Especificação: "
				+ product
				+ ", Preço: R$"
				+ String.format("%.2f ", price);
	}
	
}
