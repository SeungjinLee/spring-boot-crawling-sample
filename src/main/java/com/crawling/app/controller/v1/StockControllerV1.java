package com.crawling.app.controller.v1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crawling.app.service.CrawlingService;
import com.crawling.app.service.v1.NaverCrawlingServiceImplV1;
import com.crawling.app.service.v1.StockServiceImplV1;
import com.crawling.app.vo.StockVO;

@RestController
@RequestMapping("/v1/stock")
public class StockControllerV1 {

	private CrawlingService crawlingService;
	private StockServiceImplV1 stockService; 
	
	public StockControllerV1(NaverCrawlingServiceImplV1 crawlingService, StockServiceImplV1 stockService) {
		this.crawlingService = crawlingService;
		this.stockService = stockService;
	}

	@GetMapping("/list")
	public Object listStock() {
		List<StockVO> stockVOs = stockService.listStock();
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
