package com.anupamsingh.springaop.controller;

import com.anupamsingh.springaop.dto.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

  @PostMapping("/processPayment")
  public Payment processPayment(Payment payment) {
    // Simulate payment processing logic
    payment.setStatus("Processed");
    return payment;
  }

}
