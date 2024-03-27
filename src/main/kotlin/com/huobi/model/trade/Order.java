package com.huobi.model.trade;

import com.alibaba.fastjson.annotation.JSONField;
import com.huobi.constant.enums.StopOrderOperatorEnum;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

  private Long id;

  private String symbol;

  private Long accountId;

  private BigDecimal amount;

  private BigDecimal price;

  private String type;

  private BigDecimal filledAmount;

  private BigDecimal filledCashAmount;

  private BigDecimal filledFees;

  private String source;

  private String state;

  private Long createdAt;

  private Long canceledAt;

  private Long finishedAt;

  private BigDecimal stopPrice;

  private String clientOrderId;

  @JSONField(deserialize = false)
  private StopOrderOperatorEnum operator;

}
