package com.velocity.eShopCart.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.velocity.eShopCart.payload.ApiResponse;




@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//For get
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	//For Wrong Selection of method in PostMan
	@ExceptionHandler(RequestMethodNotSupportedException.class)
	public ResponseEntity<ApiResponse> RequestMethodNotSupported(RequestMethodNotSupportedException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
		//For Delete 	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ApiResponse> EmptyResultDataAccessException(EmptyResultDataAccessException ex) {
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
}
	 @ExceptionHandler(EntityNotFoundException.class)
	    public ResponseEntity<ApiResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
		 String message=ex.getMessage();
			ApiResponse apiResponse=new ApiResponse(message,false);
			return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	    }
}
