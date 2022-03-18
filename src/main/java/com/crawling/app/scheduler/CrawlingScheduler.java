package com.crawling.app.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.crawling.app.aspect.ExecutionTime;
import com.crawling.app.service.CrawlingService;
import com.crawling.app.service.v2.NaverCrawlingServiceImplV2;

@Component
public class CrawlingScheduler {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private CrawlingService crawlingService;

	public CrawlingScheduler(NaverCrawlingServiceImplV2 crawlingService) {
		this.crawlingService = crawlingService;
	}
	
//	@ExecutionTime
	@Scheduled(cron = "30 * * * * *")
	public void exeCrawling() {
		logger.info("CrawlingScheduler - exeCrawling Start");
		long start = System.currentTimeMillis();
		
		crawlingService.executeCrawling();
		
		long executionTime = System.currentTimeMillis() - start;
		logger.info(String.format("METHOD EXECUTION_TIME : %sms ",  executionTime));
		logger.info("CrawlingScheduler - exeCrawling End");

	}
	
}
