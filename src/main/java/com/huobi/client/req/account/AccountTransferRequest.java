package com.huobi.client.req.account;

import java.math.BigDecimal;

import lombok.*;

import com.huobi.constant.enums.AccountTransferAccountTypeEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountTransferRequest {

  private Long fromUser;

  private AccountTransferAccountTypeEnum fromAccountType;

  private Long fromAccount;

  private Long toUser;

  private AccountTransferAccountTypeEnum toAccountType;

  private Long toAccount;

  private String currency;

  private BigDecimal amount;

  public Long getFromUser() {
    return fromUser;
  }

  public AccountTransferAccountTypeEnum getFromAccountType() {
    return fromAccountType;
  }

  public Long getFromAccount() {
    return fromAccount;
  }

  public Long getToUser() {
    return toUser;
  }

  public AccountTransferAccountTypeEnum getToAccountType() {
    return toAccountType;
  }

  public Long getToAccount() {
    return toAccount;
  }

  public String getCurrency() {
    return currency;
  }

  public BigDecimal getAmount() {
    return amount;
  }
}
