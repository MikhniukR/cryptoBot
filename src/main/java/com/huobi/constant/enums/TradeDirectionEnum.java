package com.huobi.constant.enums;

/**
 * buy, sell.
 */
public enum TradeDirectionEnum {

  BUY("buy"),
  SELL("sell");
  TradeDirectionEnum(String code) {
      this.code = code;
  }
  private final String code;

  public String getCode() {
    return code;
  }

  public static TradeDirectionEnum find(String code) {
    for (TradeDirectionEnum directionEnum : TradeDirectionEnum.values()) {
      if (directionEnum.getCode().equals(code)) {
        return directionEnum;
      }
    }
    return null;
  }

}
