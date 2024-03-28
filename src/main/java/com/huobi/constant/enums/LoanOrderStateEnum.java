package com.huobi.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * created, accrual, cleared, invalid.
 */
@Getter
@AllArgsConstructor
public enum LoanOrderStateEnum {

  CREATED("created"),
  ACCRUAL("accrual"),
  CLEARED("cleared"),
  INVALID("invalid");

  private final String code;
}
