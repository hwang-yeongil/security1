package com.example.securiy1;


import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
//	Developer Custom Exception
	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<ErrorResponse> handleCustomException(final CustomException e){
		log.error("handleCustomException: {}",e.getErrorCode());
		return ResponseEntity
				.status(e.getErrorCode().getStatus().value())
				.body(new ErrorResponse(e.getErrorCode()));
	}
	
//	Http 405 Exception
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException e){
		log.error("handleHttpRequestMethodNotSupportedException: {}",e.getMessage());
		return ResponseEntity
				.status(ErrorCode.METHOD_NOT_ALLOWED.getStatus().value())
				.body(new ErrorResponse(ErrorCode.METHOD_NOT_ALLOWED));
	}
	
	
}
