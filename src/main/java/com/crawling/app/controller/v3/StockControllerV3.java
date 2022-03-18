package com.crawling.app.controller.v3;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crawling.app.dto.StockReq;
import com.crawling.app.service.v3.StockServiceImplV3;

@RestController
@RequestMapping("/v3/stock")
public class StockControllerV3 {

	private StockServiceImplV3 stockService; 

	public StockControllerV3(StockServiceImplV3 stockService) {
		this.stockService = stockService;
	}

	@PostMapping("/create")
	public Object createStock(@RequestBody @Valid StockReq req) {
		stockService.createStock(req);
		Map<String, Object> result = new HashMap();
		result.put("resultCode", "0000");
		return result;
	}
	
}
