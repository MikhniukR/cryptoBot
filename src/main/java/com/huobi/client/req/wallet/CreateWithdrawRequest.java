package com.huobi.client.req.wallet;

import java.math.BigDecimal;

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
public class CreateWithdrawRequest {

  private String address;

  private BigDecimal amount;

  private BigDecimal fee;

  private String currency;

  private String chain;

  private String addrTag;

  private String clientOrderId;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public BigDecimal getFee() {
    return fee;
  }

  public void setFee(BigDecimal fee) {
    this.fee = fee;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getChain() {
    return chain;
  }

  public void setChain(String chain) {
    this.chain = chain;
  }

  public String getAddrTag() {
    return addrTag;
  }

  public void setAddrTag(String addrTag) {
    this.addrTag = addrTag;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }

  public void setClientOrderId(String clientOrderId) {
    this.clientOrderId = clientOrderId;
  }
}
