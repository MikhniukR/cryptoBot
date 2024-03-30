package com.huobi.service.huobi.parser.generic;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huobi.model.generic.Person;
import com.huobi.model.generic.Symbol;
import com.huobi.model.generic.SymbolV2;
import com.huobi.service.huobi.parser.HuobiModelParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SymbolV2Parser implements HuobiModelParser<SymbolV2> {

    @Override
    public SymbolV2 parse(JSONObject json) {
        System.out.println("Parse " + json);
        if (json.get("p1") == null)
            return null;

        SymbolV2 result = new SymbolV2();
        result.setP1(new Person(((JSONObject)((JSONArray) json.get("p1")).getFirst()).getInteger("id"),
                ((JSONObject)((JSONArray) json.get("p1")).getFirst()).getString("name"),
                ((JSONObject)((JSONArray) json.get("p1")).getFirst()).getInteger("weight")));
        result.setBc(json.getString("bc"));
        result.setLr(json.getBigDecimal("lr"));
        result.setToa(json.getLong("toa"));

        System.out.println("Finish");
        return result;
    }

    @Override
    public SymbolV2 parse(JSONArray json) {
        System.out.println(json);
        return null;
    }

    public SymbolV2 parse(Object json) {
        if (json instanceof JSONArray)
            return parse((JSONArray) json);
        else
            return parse((JSONObject) json);
    }

    @Override
    public List<SymbolV2> parseArray(JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.size() <= 0) {
            return new ArrayList<>();
        }

        List<SymbolV2> result = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(i);
            result.add(parse(jsonArray.get(i)));
        }
        return result;

//        return (List<SymbolV2>) jsonArray.stream()
//                .map(this::parse)
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
    }
}
