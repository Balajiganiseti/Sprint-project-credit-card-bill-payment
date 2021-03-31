package com.cg.creditcardbillpayment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardbillpayment.dao.PaymentRepository;
import com.cg.creditcardbillpayment.entities.Payment;
import com.cg.creditcardbillpayment.exceptions.PaymentServiceException;
/************************************************************************************
 *          @author          G.Balaji
 *          Description      It is a service class that provides the   services to add a payment,remove
 *                            a payment,update a payment and view the payments
  *         Version             1.0
  *         Created Date     23-March-2021
 ************************************************************************************/

@Service

public class PaymentServiceImpl implements PaymentService {
	@Autowired

	private PaymentRepository paymentrepository;
	/************************************************************************************
	 * Method:                           :addPayment
     *Description:                       :To add the payment to the Database
	 * @param Payment                    - Payment to be  added to the Database
	 * @returns newPayment               - Return payment after adding the card to Database
	 * @throws PaymentServiceException   - It is raised When payment already exists in the Database                                 
     *Created By                         - G.Balaji
     *Created Date                       - 23-March-2021                          
	 
	 ************************************************************************************/

	@Override
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		Payment newPayment;
		Optional<Payment> payment1 = paymentrepository.findById(payment.getPaymentId());
		if (payment1.isEmpty()) {
			newPayment = paymentrepository.saveAndFlush(payment);

		} else {
			throw new PaymentServiceException("Payment already exists");
		}
		return newPayment;

	}
	/************************************************************************************
	 * Method:                         : remove Payment
     *Description:                     : To remove the payment to the Database
	 * @param Payment                  - Payment to be  added to the Database
	 * @returns void                   - Return void
	 * @throws PaymentServiceException - It is raised When payment does not exist in the Database                                 
     *Created By                       - G.Balaji
     *Created Date                     - 23-March-2021                          
	 
	 ************************************************************************************/

	@Override
	public Payment removePayment(long id) {
		// TODO Auto-generated method stub
		Optional<Payment> payment = paymentrepository.findById(id);
		if (payment.isEmpty())

			throw new PaymentServiceException("Id does not exist to delete");
		else
			paymentrepository.delete(payment.get());
		return null;

	}
	/************************************************************************************
	 * Method:                         : updatePayment
     *Description:                     : To update the payment to the Database
	 * @param Payment                  - Payment to be  updated the Database
	 * @returns Payment                - Return payment after updated to the Database
	 * @throws PaymentServiceException - It is raised When Id does not found in the Database                                 
     *Created By                       - G.Balaji
     *Created Date                     - 23-March-2021                          
	 
	 ************************************************************************************/

	@Override
	public Payment updatePayment(long id, Payment payment) {
		// TODO Auto-generated method stub
		Optional<Payment>payment1=paymentrepository.findById(id);
		if (payment1.isEmpty())
		{
			throw new PaymentServiceException("Id does not found");
		}
		else
			paymentrepository.save(payment);
		return payment;
	}
	/************************************************************************************
	 * Method:                         : getPayment
     *Description:                     : To fetch the payment from the Database
	 * @param Payment                  - Payment to be  updated the Database
	 * @returns Payment                - Return payment after fetch from the Database
	 * @throws PaymentServiceException - It is raised When Id does not exist in the Database                                 
     *Created By                       - G.Balaji
     *Created Date                     - 23-March-2021                          
	 ************************************************************************************/

	@Override
	public Payment getPayment(long id) {
		// TODO Auto-generated method stub
		Optional<Payment>payment = paymentrepository.findById(id);
		if (payment.isEmpty())
		{
			throw new PaymentServiceException("Given id does not exist");
	}
		return payment.get();

	}
}
