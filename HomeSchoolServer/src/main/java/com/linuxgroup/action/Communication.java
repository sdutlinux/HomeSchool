package com.linuxgroup.action;

import com.google.gson.JsonObject;
import com.linuxgroup.model.Message;
import com.linuxgroup.service.PushService;
import net.sf.json.JSONObject;
import com.linuxgroup.result.Result;
import com.linuxgroup.utils.JsonUtils;
import com.opensymphony.xwork2.Action;

import java.util.Date;

/**
 * Created by tan on 14-9-20.
 */
public class Communication {

    private PushService pushService;

    private JSONObject jsonObj;
    private JSONObject jsp;

    public String sendMessage() {

        Result result = new Result();

        /**
         *  创建一个Message对象
         */
        Message msg = new Message();
        msg.setId(123456789);
        msg.setFromAccount("1");
        msg.setToAccount("2");
        msg.setContent("hui");
        msg.setTime(new Date());
        msg.setType(1);


        jsp = JSONObject.fromObject(msg);  // 把java对象转变成json
        String str = jsp.getString("id");  // 从json里获取id的值,注意，格式是String

        try {

            System.out.println(str);    // 在控制台输出信息

            pushService.pushToAll(str);  // 将信息发送至极光推送

            result.setStatus("ok");

        } catch (Exception e) {
            result.setStatus("error");
        }

        jsonObj = JsonUtils.toJson(result);


        return Action.SUCCESS;
    }




    // set and get methods


    public JSONObject getJsonObj() {
        return jsonObj;
    }

    public void setJsonObj(JSONObject jsonObj) {
        this.jsonObj = jsonObj;
    }

    public PushService getPushService() {
        return pushService;
    }

    public void setPushService(PushService pushService) {
        this.pushService = pushService;
    }
}
