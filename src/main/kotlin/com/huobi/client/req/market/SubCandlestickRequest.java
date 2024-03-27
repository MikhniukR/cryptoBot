package com.huobi.client.req.market;

import com.huobi.constant.enums.CandlestickIntervalEnum;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubCandlestickRequest {

  private String symbol;

  private CandlestickIntervalEnum interval;

}
