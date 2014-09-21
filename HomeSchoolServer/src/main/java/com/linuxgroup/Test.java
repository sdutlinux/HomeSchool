package com.linuxgroup;

import com.google.gson.Gson;
import com.linuxgroup.result.Result;
import net.sf.json.JSONObject;

public class Test {
    public static void main(String[] args) {
        Result result = new Result();
        result.setStatus("ok");

        JSONObject jsonObject = JSONObject.fromObject(result);

        String strJson = jsonObject.toString();

        System.out.println(strJson);

        JSONObject jsonObject1 = JSONObject.fromObject(strJson);
        Result result1 = (Result)JSONObject.toBean(jsonObject1, Result.class);


        System.out.println(jsonObject1);

        jsonObject = JSONObject.fromObject(new Gson().toJson(result));

//        System.out.println(result1.getStatus() + " " + result1.getMessage());
        System.out.println(jsonObject);
    }
}

