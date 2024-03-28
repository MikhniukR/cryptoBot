package com.huobi.client.req.margin;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IsolatedMarginLoanInfoRequest {

  private String symbols;

  public String getSymbols() {
    return symbols;
  }
}
