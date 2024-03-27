package com.huobi.model.subuser;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetSubUserListResult {

  private List<SubUserState> userList;

  private Long nextId;

}
