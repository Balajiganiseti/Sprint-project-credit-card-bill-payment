package com.cg.creditcardbillpayment.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	@Id
	private Long paymentId;
	private Double dueAmount;
	private String status;
	@OneToOne
	private CreditCard card;

	public Payment() {
		super();
	}

	public Payment(long paymentId, Double dueAmount, String status, CreditCard card) {
		super();
		this.paymentId = paymentId;
		this.dueAmount = dueAmount;
		this.status = status;
		this.card = card;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Double getdueAmount() {
		return dueAmount;
	}

	public void setType(String type) {
		this.dueAmount = dueAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", dueAmount=" + dueAmount + ", status=" + status + ", card=" + card + "]";
	}
}
