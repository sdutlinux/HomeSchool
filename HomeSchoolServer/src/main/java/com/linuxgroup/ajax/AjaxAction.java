package com.linuxgroup.ajax;


import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import com.linuxgroup.service.PushService;
import net.sf.json.JSONObject;
import com.linuxgroup.result.Result;
import com.linuxgroup.utils.JsonUtils;
import com.opensymphony.xwork2.Action;

/**
 * Created by tan on 14-9-20.
 */
public class AjaxAction {

    private PushService pushService;

    private JSONObject jsonObj;

    public String sendMessage() {

        Result result = new Result();

        try {
            pushService.pushToAll("test");

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
