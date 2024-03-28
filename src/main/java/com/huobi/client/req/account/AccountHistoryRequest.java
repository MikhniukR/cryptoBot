package com.huobi.client.req.account;

import java.util.List;

import lombok.*;
import org.apache.commons.lang.StringUtils;

import com.huobi.constant.enums.QuerySortEnum;
import com.huobi.constant.enums.AccountHistoryTransactTypeEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountHistoryRequest {

  private Long accountId;

  private String currency;

  private List<AccountHistoryTransactTypeEnum> types;

  private Long startTime;

  private Long endTime;

  private QuerySortEnum sort;

  private Integer size;

  private Long fromId;

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

  public List<AccountHistoryTransactTypeEnum> getTypes() {
    return types;
  }

  public void setTypes(List<AccountHistoryTransactTypeEnum> types) {
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

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Long getFromId() {
    return fromId;
  }

  public void setFromId(Long fromId) {
    this.fromId = fromId;
  }
}
