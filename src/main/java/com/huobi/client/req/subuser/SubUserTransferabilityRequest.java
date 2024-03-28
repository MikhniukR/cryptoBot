package com.huobi.client.req.subuser;

import lombok.*;

import com.huobi.constant.enums.TransferabilityAccountTypeEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubUserTransferabilityRequest {

  private String subUids;

  private TransferabilityAccountTypeEnum accountType;

  private String transferrable;

  public String getSubUids() {
    return subUids;
  }

  public TransferabilityAccountTypeEnum getAccountType() {
    return accountType;
  }

  public String getTransferrable() {
    return transferrable;
  }
}
