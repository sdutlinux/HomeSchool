package com.linuxgroup.utils;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * Created by tan on 14-9-20.
 */
public class JsonUtils {
    public static JSONObject stringToJson(String content) throws JSONException {
        JSONObject jsonObject = JSONObject.fromObject(content);
        return jsonObject;
    }

    public static JSONObject toJson(Object obj) {
        return JSONObject.fromObject(obj);
    }
}
