package com.linuxgroup.ajax;

import com.google.gson.Gson;
import com.linuxgroup.result.Result;
import com.opensymphony.xwork2.Action;

/**
 * Created by tan on 14-9-20.
 */
public class AjaxAction {

    private String jsonObj;

    public String sendMessage() {


        Result result = new Result();
        result.setStatus("ok");

        jsonObj = new Gson().toJson(result);

        return Action.SUCCESS;
    }




    // set and get methods


    public String getJsonObj() {
        return jsonObj;
    }

    public void setJsonObj(String jsonObj) {
        this.jsonObj = jsonObj;
    }
}
