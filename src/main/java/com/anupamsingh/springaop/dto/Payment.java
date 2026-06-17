package com.anupamsingh.springaop.dto;

import lombok.Data;

@Data
public class Payment {

  private String id;
  private String orderId;
  private String status;
  private Double amount;
}
