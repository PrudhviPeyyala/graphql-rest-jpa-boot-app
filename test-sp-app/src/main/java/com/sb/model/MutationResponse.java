package com.sb.model;

public class MutationResponse {

	private String responseMessage;
	private int responseStatusCode;
	
	public MutationResponse(String responseMessage,int responseStatusCode) {
		this.responseMessage = responseMessage;
		this.responseStatusCode = responseStatusCode;
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public int getResponseStatusCode() {
		return responseStatusCode;
	}
	public void setResponseStatusCode(int responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}
	
	
}
