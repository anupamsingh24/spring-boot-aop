package com.anupamsingh.springaop.controller;

import com.anupamsingh.springaop.annotation.TaskExecution;
import com.anupamsingh.springaop.dto.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

  @PostMapping("/processPayment")
  @TaskExecution
  public Payment processPayment(Payment payment) throws InterruptedException {
    // Simulate payment processing logic
    System.out.println("Payment getting processed...");
    payment.setStatus("Processed");
    Thread.sleep(5000);
    return payment;
  }

}
