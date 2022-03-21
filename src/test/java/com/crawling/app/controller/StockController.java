package com.crawling.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.crawling.app.dto.StockReq;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class StockController {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreateStock() throws Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		StockReq req = new StockReq();
		req.setName("아톤");
		req.setPrice(500);
		req.setStockCount(10000L);
		
		this.mockMvc.perform(post("/v3/stock/create")
		    .contentType(MediaType.APPLICATION_JSON)
		    .accept(MediaType.APPLICATION_JSON)
		    .content(objectMapper.writeValueAsString(req)))
		    .andDo(print())
		    .andExpect(status().isOk());
	}
	
}
