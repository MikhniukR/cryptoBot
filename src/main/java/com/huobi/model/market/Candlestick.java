package com.huobi.model.market;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Candlestick {

  private Long id;

  private BigDecimal amount;

  private BigDecimal count;

  private BigDecimal open;

  private BigDecimal high;

  private BigDecimal low;

  private BigDecimal close;

  private BigDecimal vol;

  @Override
  public String toString() {
    return "Candlestick{" +
            ", amount=" + amount +
            ", count=" + count +
            ", open=" + open +
            ", high=" + high +
            ", low=" + low +
            ", close=" + close +
            ", vol=" + vol +
            '}';
  }
}
