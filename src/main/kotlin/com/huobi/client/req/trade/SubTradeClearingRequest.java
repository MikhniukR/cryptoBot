package com.huobi.client.req.trade;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubTradeClearingRequest {

  private String symbols;

  private int[] modes;

}
