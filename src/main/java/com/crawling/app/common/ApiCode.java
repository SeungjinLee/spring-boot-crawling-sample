package com.crawling.app.common;

public enum ApiCode {
	Success("0000","성공"),
	Error("9000","성공");
	
	private String code;
    private String msg;

    ApiCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
	}
    
    public String getCode() { return code; }
    public String getMsg() { return msg; }
}
