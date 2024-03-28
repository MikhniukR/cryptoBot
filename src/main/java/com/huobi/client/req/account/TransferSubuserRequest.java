package com.huobi.client.req.account;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.huobi.constant.enums.TransferMasterTypeEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransferSubuserRequest {

  private Long subUid;

  private String currency;

  private BigDecimal amount;

  private TransferMasterTypeEnum type;

  private String clientOrderId;

  public Long getSubUid() {
    return subUid;
  }

  public String getCurrency() {
    return currency;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public TransferMasterTypeEnum getType() {
    return type;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }
}
