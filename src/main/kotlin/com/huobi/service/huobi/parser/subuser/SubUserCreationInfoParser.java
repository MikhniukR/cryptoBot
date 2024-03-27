package com.huobi.service.huobi.parser.subuser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huobi.model.subuser.SubUserCreationInfo;
import com.huobi.service.huobi.parser.HuobiModelParser;

import java.util.List;

public class SubUserCreationInfoParser implements HuobiModelParser<SubUserCreationInfo> {

  @Override
  public SubUserCreationInfo parse(JSONObject json) {
    return null;
  }

  @Override
  public SubUserCreationInfo parse(JSONArray json) {
    return null;
  }

  @Override
  public List<SubUserCreationInfo> parseArray(JSONArray jsonArray) {
    return jsonArray.toJavaList(SubUserCreationInfo.class);
  }
}
