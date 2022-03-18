package com.crawling.app.service.v2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawling.app.entity.Stock;
import com.crawling.app.repository.StockRepository;
import com.crawling.app.service.CrawlingService;

@Service
public class NaverCrawlingServiceImplV2 implements CrawlingService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private StockRepository stockRepository;
	
	@Override
	public void executeCrawling() {
		logger.info("executeCrawling start ~~~~~~~~~~~~~~~~~~~~");
		
		List<Stock> stocks = new ArrayList<Stock>();
		
		try {
			Document doc;
			// 네이버 주식 크롤링 주소
			doc = Jsoup.connect("https://finance.naver.com/sise/sise_market_sum.naver").get();
			logger.info(doc.title());
			Elements elements = doc.select("table.type_2 tbody tr");
			for (Element element : elements) {
				if(!element.select("td:eq(0)").attr("class").contains("blank") && !element.select("td:eq(0)").attr("class").contains("division")) {
					String name = element.select("td:eq(1) > a").text();
					Integer price = Integer.parseInt(element.select("td:eq(2)").text().replaceAll(",", ""));
					Long stockCount = Long.parseLong(element.select("td:eq(7)").text().replaceAll(",", "")) * 1000;
					Long marketCapitalization = price * stockCount;
					Stock stock = new Stock();
					stock.setName(name);
					stock.setPrice(price);
					stock.setStockCount(stockCount);
					stock.setMarketCapitalization(marketCapitalization);
					stocks.add(stock);
				}
			}
			
			stockRepository.saveAll(stocks);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("executeCrawling end ~~~~~~~~~~~~~~~~~~~~");
	}

}
