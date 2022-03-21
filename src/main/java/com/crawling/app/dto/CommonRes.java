package com.crawling.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonRes<T> {

	private String resultCode;
	private String resultMsg;
	private T data;
	
	private CommonRes(String resultCode, String resultMsg, T data) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.data = data;
	}
	
	public static <T> Builder<T> builder() {
   		return new Builder<T>();
   	}
	
	public static class Builder<T> {
		private String resultCode;
		private String resultMsg;
		private T data;
		
		public Builder() {}

		public Builder resultCode(String resultCode) {
			this.resultCode = resultCode;
			return this;
		}
		
		public Builder resultMsg(String resultMsg) {
			this.resultMsg = resultMsg;
			return this;
		}
		
		public Builder data(T data) {
			this.data = data;
			return this;
		}
		
		public CommonRes build() {
			return new CommonRes(resultCode, resultMsg, data);
		}
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
