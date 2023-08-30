package com.velocity.eShopCart.exception;

import java.time.LocalDateTime;

public class RequestMethodNotSupportedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String resourceName;
	String fieldName;
	long fieldValue;
	LocalDateTime timeStamp;
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public long getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}
//	public LocalDateTime getTimeStamp() {
//		return timeStamp;
//	}
//	public void setTimeStamp(LocalDateTime timeStamp) {
//		this.timeStamp = timeStamp;
//	}
	public RequestMethodNotSupportedException(String resourceName, String fieldName, long fieldValue,
			LocalDateTime timeStamp) {
		super(String.format ("please change http method type request", resourceName, fieldName, fieldValue,timeStamp ));//,timeStamp
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		//this.timeStamp = timeStamp;
	}
	
	
}
