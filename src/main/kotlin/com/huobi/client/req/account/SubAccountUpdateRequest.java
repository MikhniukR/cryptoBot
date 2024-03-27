package com.huobi.client.req.account;

import com.huobi.constant.enums.AccountUpdateModeEnum;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubAccountUpdateRequest {

  private AccountUpdateModeEnum accountUpdateMode;

}
