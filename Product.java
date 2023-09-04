package model;

public class Product {
	private String prodId;
	private String prodName;
	private int sellingQuantity;
	private int prodCost;
	private int stock ;
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getSellingQuantity() {
		return sellingQuantity;
	}
	public void setSellingQuantity(int sellingQuantity) {
		this.sellingQuantity = sellingQuantity;
	}
	public int getProdCost() {
		return prodCost;
	}
	public void setProdCost(int prodCost) {
		this.prodCost = prodCost;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	

}
