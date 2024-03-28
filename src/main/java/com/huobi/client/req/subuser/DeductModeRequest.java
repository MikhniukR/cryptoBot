package com.huobi.client.req.subuser;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeductModeRequest {
    private Long subUids;
    private String deductMode;

    public Long getSubUids() {
        return subUids;
    }

    public String getDeductMode() {
        return deductMode;
    }
}
