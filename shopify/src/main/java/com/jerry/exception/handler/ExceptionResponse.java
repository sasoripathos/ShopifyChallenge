package com.jerry.exception.handler;

public class ExceptionResponse {
	
	private int status;
	private String reason;
	private long timestamp;
	private String url;
	
	public ExceptionResponse() {
		this.timestamp = System.currentTimeMillis();
	}

	public ExceptionResponse(int status, String reason, String url) {
		this.status = status;
		this.reason = reason;
		this.timestamp = System.currentTimeMillis();
		this.url = url;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
