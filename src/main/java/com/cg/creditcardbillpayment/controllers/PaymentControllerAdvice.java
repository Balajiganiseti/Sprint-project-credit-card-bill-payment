package com.cg.creditcardbillpayment.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.creditcardbillpayment.exceptions.PaymentServiceException;

@RestControllerAdvice
public class PaymentControllerAdvice {
	@ExceptionHandler(PaymentServiceException.class)
	public ResponseEntity<String> foundPaymentException(Exception exception) {

		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}