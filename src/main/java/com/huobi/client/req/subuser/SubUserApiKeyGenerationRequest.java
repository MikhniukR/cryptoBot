package com.huobi.client.req.subuser;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubUserApiKeyGenerationRequest {

  private String otpToken;

  private Long subUid;

  private String note;

  private String permission;

  private String ipAddresses;

  public String getOtpToken() {
    return otpToken;
  }

  public Long getSubUid() {
    return subUid;
  }

  public String getNote() {
    return note;
  }

  public String getPermission() {
    return permission;
  }

  public String getIpAddresses() {
    return ipAddresses;
  }
}
