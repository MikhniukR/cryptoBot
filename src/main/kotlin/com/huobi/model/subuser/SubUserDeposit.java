package com.huobi.model.subuser;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubUserDeposit {

  private Long id;

  private String currency;

  private String txHash;

  private String chain;

  private BigDecimal amount;

  private String address;

  private String addressTag;

  private String state;

  private Long createTime;

  private Long updateTime;

}
