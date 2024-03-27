package com.huobi.model.isolatedmargin;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IsolatedMarginSymbolInfo {

  private String symbol;

  private List<IsolatedMarginCurrencyInfo> currencies;

}
