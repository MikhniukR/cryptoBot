package com.huobi.constant.enums.algo;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum AlgoOrderTypeEnum {

  LIMIT("limit"),
  MARKET("market"),

  ;
  AlgoOrderTypeEnum(String type) {
    this.type = type;
  }
  private final String type;

  public String getType() {
    return type;
  }
}
