package com.huobi.client.req.crossmargin;

import com.huobi.constant.enums.MarginTransferDirectionEnum;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CrossMarginTransferRequest {

  private MarginTransferDirectionEnum direction;

  private String currency;

  private BigDecimal amount;

}
