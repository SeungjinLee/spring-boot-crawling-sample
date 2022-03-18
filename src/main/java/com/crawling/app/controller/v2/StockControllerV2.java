package com.crawling.app.controller.v2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crawling.app.entity.Stock;
import com.crawling.app.service.CrawlingService;
import com.crawling.app.service.v2.NaverCrawlingServiceImplV2;
import com.crawling.app.service.v2.StockServiceImplV2;

@RestController
@RequestMapping("/v2/stock")
public class StockControllerV2 {

	private CrawlingService crawlingService;
	private StockServiceImplV2 stockService; 

	public StockControllerV2(NaverCrawlingServiceImplV2 crawlingService, StockServiceImplV2 stockService) {
		this.crawlingService = crawlingService;
		this.stockService = stockService;
	}

	@GetMapping("/list")
	public Object listStock() {
		List<Stock> stockVOs = stockService.listStock();
		Map<String, Object> result = new HashMap();
		result.put("resultCode", "0000");
		result.put("data", stockVOs);
		return result;
	}
	
	@GetMapping("/crawling")
	public Object crawling() {
		crawlingService.executeCrawling();
		Map<String, Object> result = new HashMap();
		result.put("resultCode", "0000");
		return result;
	}
	
}
