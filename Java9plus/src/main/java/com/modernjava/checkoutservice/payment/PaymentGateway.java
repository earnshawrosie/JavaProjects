package com.modernjava.checkoutservice.payment;

import com.modernjava.checkoutservice.domain.Card;
import com.modernjava.checkoutservice.domain.PaymentResponse;

public abstract sealed class PaymentGateway permits DebitCardPayment, CreditCardPayment, RewardsCardPayment {
	
	public abstract PaymentResponse makePayment(Card card, Double amount);

}
