package com.crawling.app.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class APIExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Object handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		Map<String, Object> result = new HashMap();
		result.put("resultCode", "9000");
		result.put("resultMsg", ex.getMessage());
		return result;
	}

}
