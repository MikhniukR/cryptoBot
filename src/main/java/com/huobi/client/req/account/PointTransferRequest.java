package com.huobi.client.req.account;


import java.math.BigDecimal;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PointTransferRequest {

  private Long fromUid;

  private Long toUid;

  private Long groupId;

  private BigDecimal amount;

  public Long getFromUid() {
    return fromUid;
  }

  public void setFromUid(Long fromUid) {
    this.fromUid = fromUid;
  }

  public Long getToUid() {
    return toUid;
  }

  public void setToUid(Long toUid) {
    this.toUid = toUid;
  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
