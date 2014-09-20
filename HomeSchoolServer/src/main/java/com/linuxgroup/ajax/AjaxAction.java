package com.linuxgroup.ajax;


import net.sf.json.JSONObject;
import com.linuxgroup.result.Result;
import com.linuxgroup.utils.JsonUtils;
import com.opensymphony.xwork2.Action;

/**
 * Created by tan on 14-9-20.
 */
public class AjaxAction {

    private JSONObject jsonObj;

    public String sendMessage() {


        Result result = new Result();
        result.setStatus("ok");

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
}
