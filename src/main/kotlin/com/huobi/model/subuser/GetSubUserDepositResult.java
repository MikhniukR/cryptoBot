package com.huobi.model.subuser;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetSubUserDepositResult {

  private List<SubUserDeposit> list;

  private Long nextId;

}
