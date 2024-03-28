package com.huobi.client.req.subuser;

import lombok.*;

import com.huobi.constant.enums.TradableMarketAccountTypeEnum;
import com.huobi.constant.enums.TradableMarketActivationEnums;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubUserTradableMarketRequest {

  private String subUids;

  private TradableMarketAccountTypeEnum accountType;

  private TradableMarketActivationEnums activation;

  public String getSubUids() {
    return subUids;
  }

  public TradableMarketAccountTypeEnum getAccountType() {
    return accountType;
  }

  public TradableMarketActivationEnums getActivation() {
    return activation;
  }
}
