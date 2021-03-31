package com.cg.creditcardbillpayment.exceptions;

public class PaymentServiceException extends RuntimeException {
	
	public  PaymentServiceException (String msg) {
		super(msg);
	}
	
}