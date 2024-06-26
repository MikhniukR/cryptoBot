package com.huobi.client.req.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.huobi.constant.enums.DepthSizeEnum;
import com.huobi.constant.enums.DepthStepEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MarketDepthRequest {

  private String symbol;

  private DepthSizeEnum depth;

  private DepthStepEnum step;

  public MarketDepthRequest(String symbol, DepthStepEnum step) {
    this.symbol = symbol;
    this.step = step;
  }

  public String getSymbol() {
    return symbol;
  }

  public DepthSizeEnum getDepth() {
    return depth;
  }

  public DepthStepEnum getStep() {
    return step;
  }
}
