package com.huobi.client.req.margin;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LeveragePositionLimitRequest {
    private String currency;

    public String getCurrency() {
        return currency;
    }
}
