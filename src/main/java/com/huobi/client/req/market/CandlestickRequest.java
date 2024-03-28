package com.huobi.client.req.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.huobi.constant.enums.CandlestickIntervalEnum;

@Data
@Builder
@NoArgsConstructor
@ToString
public class CandlestickRequest {

  public CandlestickRequest(String symbol, CandlestickIntervalEnum interval, Integer size) {
    this.symbol = symbol;
    this.interval = interval;
    this. size = size;
  }

  private String symbol;

  private CandlestickIntervalEnum interval;

  private Integer size;

  public String getSymbol() {
    return symbol;
  }

  public CandlestickIntervalEnum getInterval() {
    return interval;
  }

  public Integer getSize() {
    return size;
  }
}
