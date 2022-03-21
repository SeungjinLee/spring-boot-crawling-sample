package com.crawling.app.service.v3;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawling.app.aspect.ExecutionTime;
import com.crawling.app.dto.StockReq;
import com.crawling.app.entity.Stock;
import com.crawling.app.repository.StockRepository;

@Service
public class StockServiceImplV3 {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StockRepository stockRepository;
	
	@ExecutionTime
	public void createStock(StockReq req){
		logger.info("StockServiceImplV3 - createStock");
		Stock stock = new Stock();
		stock.setName(req.getName());
		stock.setPrice(req.getPrice());
		stock.setStockCount(req.getStockCount());
		stock.setMarketCapitalization(req.getPrice() * req.getStockCount());
		stockRepository.save(stock);
	}
	
	@ExecutionTime
	public List<Stock> listStock(){
		logger.info("StockServiceImplV3 - listStock");
		return stockRepository.findAll();
	}
	
}
