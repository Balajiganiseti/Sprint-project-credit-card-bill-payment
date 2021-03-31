package com.cg.creditcardbillpayment.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.creditcardbillpayment.entities.CreditCard;
import com.cg.creditcardbillpayment.entities.Payment;
import com.cg.creditcardbillpayment.exceptions.PaymentServiceException;
/************************************************************************************
 *          @author          G.Balaji
 *          Description      It is a Test class that provides the testcase  to test the PaymentService Class
  *         Version             1.0
  *         Created Date    22-March-2020
 ************************************************************************************/

@SpringBootTest

public class PaymentServiceTest {
	@Autowired
	private PaymentService paymentservice;
	CreditCard creditcard = new CreditCard();
	Payment payment = new Payment(104, 20.0, "1234", creditcard);

	@Test
	void AddTest() {
		assertThrows(PaymentServiceException.class, () -> {
			paymentservice.addPayment(payment);
		});
	}

	@Test
	void getTest1() {
		assertEquals(20.0, paymentservice.getPayment(payment.getPaymentId()).getdueAmount());

	}

	@Test
	void getTest2() {
		assertEquals("1234", paymentservice.getPayment(payment.getPaymentId()).getStatus());
	}

	@Test
	void getTest3() {
		assertEquals(104, paymentservice.getPayment(payment.getPaymentId()).getPaymentId());
	}

	@Test
	void updateTest1() {
		assertEquals("1234", paymentservice.getPayment(104).getStatus());
	}

	@Test
	void updateTest2() {
		assertEquals(20.0, paymentservice.getPayment(104).getdueAmount());
	}

	@Test
	void updateTest3() {
		assertEquals(104, paymentservice.getPayment(104).getPaymentId());

	}

	@Test
	void deleteTest() {
		assertThrows(PaymentServiceException.class, () -> {
			paymentservice.removePayment(1);;
			;
		});
	}

}
