package com.cg.creditcardbillpayment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcardbillpayment.entities.Payment;
import com.cg.creditcardbillpayment.exceptions.PaymentServiceException;
import com.cg.creditcardbillpayment.services.PaymentService;

@RestController
@RequestMapping("/")

public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	/************************************************************************************
	 * Method                              : addPayment 
	 * Description                         : To add the payment from the Database
	 * @param Payment                      - payment to be added to the Database
	 * @param RequestBody                  - It maps the HttpRequest body to a transfer or domain
	                                            object, enabling automatic deserialization of the inbound
	                                            HttpRequest body onto a Java object.
	 * @returns Payment                    - returns Payment
	 * @throws PaymentServiceException     - It is raised when payment already
	                                        exists in the Database 
	 * Created By                          -  G.Balaji 
	 *Created Date                         - 24-03-2021
	 ************************************************************************************/
	@PostMapping("/insertpayment")
	public ResponseEntity<Payment> insertPayment(@RequestBody Payment payment) {
		Payment resultPayment = paymentService.addPayment(payment);
		return new ResponseEntity<Payment>(resultPayment, HttpStatus.OK);

	}
	/************************************************************************************
	 * Method                              : deletePayment 
	 * Description                         : To remove the payment from the Database
	 * @param Payment                      - payment to be deleted from the Database
	 * @param PathVariable                 - It maps the HttpRequest body to a transfer or domain
	                                            object, enabling automatic deserialization of the inbound
	                                            HttpRequest body onto a Java object.
	 * @returns Payment                    - returns Payment
	 * @throws PaymentServiceException     - It is raised when payment already
	                                         removed from the Database 
	 * Created By                          -  G.Balaji 
	 *Created Date                         - 24-03-2021
	 ************************************************************************************/
	@DeleteMapping("/deletepayment/{id}")
	public void removePaymentVariable(@PathVariable long id) throws PaymentServiceException {
		paymentService.removePayment(id);

	}
	/************************************************************************************
	 * Method                              : update Payment 
	 * Description                         : To update the payment to the Database
	 * @param Payment                      - payment to  be update from the Database
	 * @param RequestBody                  - It maps the HttpRequest body to a transfer or domain
	                                            object, enabling automatic deserialization of the inbound
	                                            HttpRequest body onto a Java object.
	 * @returns Payment                    - returns Payment
	 * @throws PaymentServiceException     - It is raised when payment already
	                                         exists in the Database 
	 * Created By                          -  G.Balaji 
	 *Created Date                         - 24-03-2021
	 ************************************************************************************/
	@PutMapping("/updatepayment")
	public ResponseEntity<Payment> updatepayment(@RequestBody Payment payment) {
		Payment resultpayment = paymentService.updatePayment(payment.getPaymentId(), payment);
		return new ResponseEntity<Payment>(resultpayment, HttpStatus.OK);

	}
	/************************************************************************************
	 * Method                              : find Payment 
	 * Description                         : To get the payment from the Database
	 * @param Payment                      - payment to be get from the Database
	 * @param PathVariable                 - It maps the HttpRequest body to a transfer or domain
	                                            object, enabling automatic deserialization of the inbound
	                                            HttpRequest body onto a Java object.
	 * @returns Payment                    - returns Payment
	 * @throws PaymentServiceException     - It is raised when payment already
	                                         exists in the Database 
	 * Created By                          -  G.Balaji 
	 *Created Date                         - 24-03-2021
	 ************************************************************************************/
	@GetMapping("/findpayment/{id}")
	public ResponseEntity<Payment> findPayment(@PathVariable long id) throws PaymentServiceException {
		Payment resultpayment = paymentService.getPayment(id);
		return new ResponseEntity<Payment>(resultpayment, HttpStatus.OK);

	}

}
