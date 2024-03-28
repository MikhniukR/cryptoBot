package com.huobi.client.req.account;

import java.math.BigDecimal;

import lombok.*;

import com.huobi.constant.enums.AccountFuturesTransferTypeEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountFuturesTransferRequest {

  private String currency;

  private BigDecimal amount;

  private AccountFuturesTransferTypeEnum type;


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public AccountFuturesTransferTypeEnum getType() {
    return type;
  }

  public void setType(AccountFuturesTransferTypeEnum type) {
    this.type = type;
  }
}
