package com.huobi.client.req.algo;

import java.math.BigDecimal;

import lombok.*;

import com.huobi.constant.enums.algo.AlgoOrderSideEnum;
import com.huobi.constant.enums.algo.AlgoOrderTimeInForceEnum;
import com.huobi.constant.enums.algo.AlgoOrderTypeEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateAlgoOrderRequest {

  private String clientOrderId;

  private Long accountId;

  private String symbol;

  private AlgoOrderSideEnum orderSide;

  private AlgoOrderTypeEnum orderType;

  private AlgoOrderTimeInForceEnum timeInForce;

  private BigDecimal orderPrice;

  private BigDecimal orderSize;

  private BigDecimal orderValue;

  private BigDecimal stopPrice;

  private BigDecimal trailingRate;

  public String getClientOrderId() {
    return clientOrderId;
  }

  public Long getAccountId() {
    return accountId;
  }

  public String getSymbol() {
    return symbol;
  }

  public AlgoOrderSideEnum getOrderSide() {
    return orderSide;
  }

  public AlgoOrderTypeEnum getOrderType() {
    return orderType;
  }

  public AlgoOrderTimeInForceEnum getTimeInForce() {
    return timeInForce;
  }

  public BigDecimal getOrderPrice() {
    return orderPrice;
  }

  public BigDecimal getOrderSize() {
    return orderSize;
  }

  public BigDecimal getOrderValue() {
    return orderValue;
  }

  public BigDecimal getStopPrice() {
    return stopPrice;
  }

  public BigDecimal getTrailingRate() {
    return trailingRate;
  }
}
