package com.huobi.client.req.generic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrencyChainsRequest {

  private String currency;

  @Builder.Default
  private boolean authorizedUser = true;

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public boolean isAuthorizedUser() {
    return authorizedUser;
  }

  public void setAuthorizedUser(boolean authorizedUser) {
    this.authorizedUser = authorizedUser;
  }
}
