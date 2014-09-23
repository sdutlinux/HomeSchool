package com.linuxgroup.action;

import com.linuxgroup.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by tan on 14-9-22.
 */
@Controller
@RequestMapping("/messge")
public class MessageRestul {

    

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Message get(HttpServletRequest request, HttpServletResponse response,
                    @PathVariable String id) {
        /*StringBuilder msg = new StringBuilder();
        msg.append("{\"msg\":\"").append("——这是你刚才传入的第二个参数 " + id + "\"}");
        printData(response, msg);*/

        Message message = new Message();
        message.setId(1);
        message.setContent("haha");

        return message;
    }

    private void printData(HttpServletResponse response, StringBuilder msg) {
        try {
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"));
            out.println(msg);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
