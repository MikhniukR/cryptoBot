package com.huobi.client.req.subuser;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubUserApiKeyDeletionRequest {

  private Long subUid;

  private String accessKey;

  public Long getSubUid() {
    return subUid;
  }

  public String getAccessKey() {
    return accessKey;
  }
}
