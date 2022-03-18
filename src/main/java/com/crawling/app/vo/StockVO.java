package com.crawling.app.vo;

public class StockVO {

	private String name;
	private Integer price;
	private Long stockCount;
	private Long marketCapitalization;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Long getStockCount() {
		return stockCount;
	}
	public void setStockCount(Long stockCount) {
		this.stockCount = stockCount;
	}
	public Long getMarketCapitalization() {
		return marketCapitalization;
	}
	public void setMarketCapitalization(Long marketCapitalization) {
		this.marketCapitalization = marketCapitalization;
	}
	
	@Override
	public String toString() {
		return "StockVO [name=" + name + ", price=" + price + ", stockCount=" + stockCount + ", marketCapitalization="
				+ marketCapitalization + "]";
	}
	
}
