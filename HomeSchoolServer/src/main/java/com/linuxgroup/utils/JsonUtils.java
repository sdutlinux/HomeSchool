package com.linuxgroup.utils;

import com.google.gson.Gson;
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
        // 单用这一句会报 java.lang.reflect.InvocationTargetException 的错误
        // 原因是，obj 内部有的属性为空
        // return JSONObject.fromObject(obj);

        // 这样使用，能够去掉 json字符里面的空的属性
        return JSONObject.fromObject(new Gson().toJson(obj));
    }


}
