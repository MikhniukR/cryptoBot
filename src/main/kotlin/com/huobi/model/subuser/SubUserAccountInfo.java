package com.huobi.model.subuser;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubUserAccountInfo {

  private String accountType;

  private String activation;

  private Boolean transferrable;

  private List<SubUserAccount> accountIds;

}
