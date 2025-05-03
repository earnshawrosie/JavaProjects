package com.modernjava.checkoutservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import com.modernjava.checkoutservice.domain.Card;
import com.modernjava.checkoutservice.domain.CardType;
import com.modernjava.checkoutservice.domain.CheckOutStatus;
import com.modernjava.checkoutservice.domain.OrderDetails;
import com.modernjava.checkoutservice.payment.PaymentService;

public class CheckoutServiceTest {


    PaymentService paymentService = new PaymentService();
    CheckoutService checkoutService = new CheckoutService(paymentService);
    
    @EnumSource(CardType.class)
    @ParameterizedTest(name="Checkout for card type") 
    public void checkout(CardType cardType) {
    	var orderDetails = orderDetails(cardType);
    	var response = checkoutService.checkoutOrder(orderDetails);
    	assertEquals(CheckOutStatus.SUCCESS, response);
    }

    static OrderDetails orderDetails(CardType cardType) {

        var card = new Card("ABC", "7676709809809809",
                "4567", "09/99", cardType);
        return new OrderDetails("1234", card, 99.0);

    }
}
