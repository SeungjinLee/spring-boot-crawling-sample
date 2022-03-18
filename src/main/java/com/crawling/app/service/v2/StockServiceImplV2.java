package com.crawling.app.service.v2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawling.app.aspect.ExecutionTime;
import com.crawling.app.entity.Stock;
import com.crawling.app.repository.StockRepository;
import com.crawling.app.vo.StockVO;

@Service
public class StockServiceImplV2 {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StockRepository stockRepository;
	
	@ExecutionTime
	public List<Stock> listStock(){
		logger.info("StockServiceImplV2 - listStock");
		return stockRepository.findAll();
	}
	
}
