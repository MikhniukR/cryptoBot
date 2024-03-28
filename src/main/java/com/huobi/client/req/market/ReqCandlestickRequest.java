package com.huobi.client.req.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.huobi.constant.enums.CandlestickIntervalEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReqCandlestickRequest {

  private String symbol;

  private CandlestickIntervalEnum interval;

  private Long from;

  private Long to;

  public String getSymbol() {
    return symbol;
  }

  public CandlestickIntervalEnum getInterval() {
    return interval;
  }

  public Long getFrom() {
    return from;
  }

  public Long getTo() {
    return to;
  }
}
