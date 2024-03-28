package com.huobi.client.req.subuser;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubUserCreationParam {

  private String userName;

  private String note;

  public String getUserName() {
    return userName;
  }

  public String getNote() {
    return note;
  }
}
