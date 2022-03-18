package com.crawling.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crawling.app.vo.StockVO;

@Configuration
public class AppConfig {

	@Bean
	public List<StockVO> stockVOs(){
		return new ArrayList<StockVO>();
	}
	
}
