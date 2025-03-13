package com.restfulservices.springweb.rest_launcher3.advise;

import java.time.LocalDateTime;

public class ErrorDetails {
	private String statusCode;
	private String msg;
	private LocalDateTime localDateTime;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDateTime getlocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	@Override
	public String toString() {
		return "ErrorDetails [statusCode=" + statusCode + ", msg=" + msg + ", LocalDateTime=" + localDateTime + "]";
	}
	public ErrorDetails(String statusCode, String msg, LocalDateTime localDateTime) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
		this.localDateTime = localDateTime;
	}
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
