package com.huobi.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum  AccountTransferAccountTypeEnum {

  SPOT("spot"),
  MARGIN("margin"),

  ;
  AccountTransferAccountTypeEnum(String accountType) {
    this.accountType = accountType;
  }

  public String getAccountType() {
    return accountType;
  }

  private String accountType;

}
