package com.huobi.client.req.algo;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CancelAlgoOrderRequest {

  private List<String> clientOrderIds;

}
