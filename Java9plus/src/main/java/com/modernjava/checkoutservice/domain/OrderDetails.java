package com.modernjava.checkoutservice.domain;

public record OrderDetails(String orderId,

                           Card card,
                           double finalAmount) {
}
