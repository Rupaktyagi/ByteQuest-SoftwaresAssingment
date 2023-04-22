package com.ByteQuest_Softwares.Exeption;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyError> getAddressException(ProductException ae,WebRequest req){
		
		MyError mr=new MyError(req.getDescription(false), ae.getMessage(), LocalTime.now());
		return new ResponseEntity<MyError>(mr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError> noException(NoHandlerFoundException noh,WebRequest req){
		
		MyError mr=new MyError(req.getDescription(false),noh.getMessage(),LocalTime.now());

	return new ResponseEntity<MyError>(mr, HttpStatus.BAD_REQUEST);	
	}
	
}
