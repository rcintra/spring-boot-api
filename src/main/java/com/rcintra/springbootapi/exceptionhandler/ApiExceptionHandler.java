package com.rcintra.springbootapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rcintra.springbootapi.domain.exception.CadastroException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageBundle;
	
	@ExceptionHandler(CadastroException.class)
	public ResponseEntity<Object> handleCadastroException(CadastroException ex, WebRequest req) {
		var status = HttpStatus.BAD_REQUEST;
		var error = new ErrorHandler();
		error.setStatus(status.value());
		error.setTitle(ex.getMessage());
		error.setDateTime(LocalDateTime.now());
		
		return handleExceptionInternal(ex, error, new HttpHeaders(), status, req);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var fields = new ArrayList<ErrorHandler.Field>();
		
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError)error).getField();
			String msg = messageBundle.getMessage(error, LocaleContextHolder.getLocale());
			
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
