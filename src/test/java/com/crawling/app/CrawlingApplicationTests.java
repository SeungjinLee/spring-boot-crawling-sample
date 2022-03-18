package com.crawling.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.crawling.app.vo.StockVO;

@SpringBootTest
class CrawlingApplicationTests {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	void naverCrawlingV1() {
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
					logger.info("name - {} | price - {} | stockCount - {} | marketCapitalization - {}", name,price,stockCount,marketCapitalization);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void naverCrawlingV2() {
		List<StockVO> stockVOs = new ArrayList();
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
					StockVO vo = new StockVO();
					vo.setName(name);
					vo.setPrice(price);
					vo.setStockCount(stockCount);
					vo.setMarketCapitalization(marketCapitalization);
					stockVOs.add(vo);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 데이터 확인
		for (StockVO stockVO : stockVOs) {
			System.out.println(stockVO.toString());
		}
	}
	

}
