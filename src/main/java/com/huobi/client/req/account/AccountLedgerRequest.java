package com.huobi.client.req.account;

import java.util.List;

import lombok.*;
import org.apache.commons.lang.StringUtils;

import com.huobi.constant.enums.AccountLedgerTransactTypeEnum;
import com.huobi.constant.enums.QuerySortEnum;

@Data
@Builder
@NoArgsConstructor
@ToString
public class AccountLedgerRequest {

  private Long accountId;

  private String currency;

  private List<AccountLedgerTransactTypeEnum> types;

  private Long startTime;

  private Long endTime;

  private QuerySortEnum sort;

  private Integer limit;

  private Long fromId;

  public AccountLedgerRequest(Long accountId) {
    this.accountId = accountId;
  }

  public AccountLedgerRequest(Long accountId, String currency, List<AccountLedgerTransactTypeEnum> types, Long startTime, Long endTime, QuerySortEnum sort, Integer limit, Long fromId) {
    this.accountId = accountId;
    this.currency = currency;
    this.types = types;
    this.startTime = startTime;
    this.endTime = endTime;
    this.sort = sort;
    this.limit = limit;
    this.fromId = fromId;
  }

  public String getTypesString(){
    String typeString = null;
    if (this.getTypes() != null && this.getTypes().size() > 0) {
      typeString = StringUtils.join(types,",");
    }
    return typeString;
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public List<AccountLedgerTransactTypeEnum> getTypes() {
    return types;
  }

  public void setTypes(List<AccountLedgerTransactTypeEnum> types) {
    this.types = types;
  }

  public Long getStartTime() {
    return startTime;
  }

  public void setStartTime(Long startTime) {
    this.startTime = startTime;
  }

  public Long getEndTime() {
    return endTime;
  }

  public void setEndTime(Long endTime) {
    this.endTime = endTime;
  }

  public QuerySortEnum getSort() {
    return sort;
  }

  public void setSort(QuerySortEnum sort) {
    this.sort = sort;
  }

  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public Long getFromId() {
    return fromId;
  }

  public void setFromId(Long fromId) {
    this.fromId = fromId;
  }
}
