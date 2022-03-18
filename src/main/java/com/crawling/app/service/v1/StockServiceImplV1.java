package com.crawling.app.service.v1;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawling.app.vo.StockVO;

@Service
public class StockServiceImplV1 {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private List<StockVO> stockVOs;
	
	public List<StockVO> listStock(){
		logger.info("StockServiceImplV1 - listStock size {}", stockVOs.size());
		return stockVOs;
	}
	
}
