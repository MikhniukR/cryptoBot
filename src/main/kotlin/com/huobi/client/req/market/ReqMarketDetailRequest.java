package com.huobi.client.req.market;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReqMarketDetailRequest {

  private String symbol;

}
