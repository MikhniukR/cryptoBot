package com.huobi.client.req.subuser;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetApiKeyListRequest {

  private Long uid;

  private String accessKey;

  public Long getUid() {
    return uid;
  }

  public String getAccessKey() {
    return accessKey;
  }
}
