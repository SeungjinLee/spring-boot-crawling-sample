package com.crawling.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
//@SequenceGenerator(name = "SEQ_STOCK_PK_GEN", sequenceName = "SEQ_STOCK_PK", allocationSize = 1)
public class Stock {

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STOCK_PK_GEN")
//	@Column(name = "STOCK_SEQ", nullable = false)
//	private Long stockSeq;

	@Id
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PRICE")
	private Integer price;
	
	@Column(name = "STOCK_COUNT")
	private Long stockCount;
	
	@Column(name = "MARKET_CAPITALIZATION")
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
	
	
	
}
