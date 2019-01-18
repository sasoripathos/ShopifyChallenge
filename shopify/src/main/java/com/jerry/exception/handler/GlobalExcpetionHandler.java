package com.jerry.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jerry.exception.ProductNotAvailableException;
import com.jerry.exception.ProductNotExistException;

@ControllerAdvice
public class GlobalExcpetionHandler {
	
	@ExceptionHandler(ProductNotAvailableException.class)
	public ResponseEntity<ExceptionResponse> productNotAvailable(HttpServletRequest rq, ProductNotAvailableException e) {
		ExceptionResponse rsp = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), rq.getRequestURL().toString());
		return new ResponseEntity<ExceptionResponse>(rsp, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProductNotExistException.class)
	public ResponseEntity<ExceptionResponse> productNotExist(HttpServletRequest rq, ProductNotExistException e) {
		ExceptionResponse rsp = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), rq.getRequestURL().toString());
		return new ResponseEntity<ExceptionResponse>(rsp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ExceptionResponse> argumentException(HttpServletRequest rq, IllegalArgumentException e) {
		ExceptionResponse rsp = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), rq.getRequestURL().toString());
		return new ResponseEntity<ExceptionResponse>(rsp, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> generalException(HttpServletRequest rq, Exception e) {
		ExceptionResponse rsp = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), rq.getRequestURL().toString());
		return new ResponseEntity<ExceptionResponse>(rsp, HttpStatus.BAD_REQUEST);
	}
}
