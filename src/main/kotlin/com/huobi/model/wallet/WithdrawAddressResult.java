package com.huobi.model.wallet;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WithdrawAddressResult {

  private Long nextId;

  private List<WithdrawAddress> withdrawAddressList;

}
