package com.strip.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.strip.error.respone.Error_message;

@ControllerAdvice
public class AppExceptionHandler extends  ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleranyException(Exception ex, WebRequest  request){
		String error_meassge_description = ex.getLocalizedMessage();// ex.getMessage();
		if(error_meassge_description == null)
			
			error_meassge_description= ex.toString();
		Error_message error_message=new Error_message(new Date(), error_meassge_description);
		return  new ResponseEntity<>(error_message,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
	@ExceptionHandler(value = {NullPointerException.class,User_service_exception.class})
	public ResponseEntity<Object> handler_specific_exception(Exception ex, WebRequest  request){
		String error_meassge_description = ex.getLocalizedMessage();// ex.getMessage();
		
		if(error_meassge_description == null)
			error_meassge_description= ex.toString();
		Error_message error_message=new Error_message(new Date(), error_meassge_description);
		return  new ResponseEntity<>(error_message,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

	
	
}
