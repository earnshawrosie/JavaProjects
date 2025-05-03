package com.modernjava.checkoutservice.payment;

import com.modernjava.checkoutservice.domain.OrderDetails;
import com.modernjava.checkoutservice.domain.PaymentResponse;

public class PaymentService {

    public PaymentResponse makePayment(OrderDetails orderDetails) {

        //implement a payment gateway that can handle the different kinds of payment.
    	var paymentGateway = PaymentFactory.paymentGateway(orderDetails.card().cardType());
    	return paymentGateway.makePayment(orderDetails.card(), orderDetails.finalAmount());
    }
}
