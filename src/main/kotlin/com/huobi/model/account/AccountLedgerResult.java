package com.huobi.model.account;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountLedgerResult {

  private Long nextId;

  private List<AccountLedger> ledgerList;

}
