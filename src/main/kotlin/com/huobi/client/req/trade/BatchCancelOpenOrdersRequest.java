package com.huobi.client.req.trade;

import com.huobi.constant.enums.OrderSideEnum;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BatchCancelOpenOrdersRequest {

  private Long accountId;

  private String symbol;

  private OrderSideEnum side;

  private Integer size;

  private String types;

}
