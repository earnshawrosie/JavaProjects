package com.modernjava.checkoutservice.payment;

import com.modernjava.checkoutservice.domain.Card;
import com.modernjava.checkoutservice.domain.PaymentResponse;

public final class CreditCardPayment extends PaymentGateway {

	@Override
	public PaymentResponse makePayment(Card card, Double amount) {
		System.out.println("Acquire Credit card payment for the ampunt : " + amount);
		return PaymentResponse.SUCCESS;
	}

}
