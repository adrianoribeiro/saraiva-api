package br.com.saraiva.model.stub;

public class BookStub {

	private String sku;
	
	private String name;
	
	private String brand;
	
	private PriceStub price;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public PriceStub getPrice() {
		return price;
	}

	public void setPrice(PriceStub price) {
		this.price = price;
	}
}
