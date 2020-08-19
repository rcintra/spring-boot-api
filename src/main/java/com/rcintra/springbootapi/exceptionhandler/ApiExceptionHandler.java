package com.rcintra.springbootapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var fields = new ArrayList<ErrorHandler.Field>();
		
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError)error).getField();
			String msg = error.getDefaultMessage();
			
			fields.add(new ErrorHandler.Field(name, msg));
		}
		
		var errorHandler = new ErrorHandler();
		errorHandler.setStatus(status.value());
		errorHandler.setTitle("One or more fields invalid.");
		errorHandler.setDateTime(LocalDateTime.now());
		return super.handleExceptionInternal(
				ex, errorHandler, headers, status, request);
	}
}