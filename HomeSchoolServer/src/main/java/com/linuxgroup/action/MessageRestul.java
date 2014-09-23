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
import java.sql.Time;
import java.util.Date;
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
                    @PathVariable Integer id) {

        Message message = new Message();
        message.setId(id);
        message.setContent("小测试 娃哈哈");
        message.setFromAccount("18369905136");
        message.setToAccount("18369905506");
        message.setTime(new Date());
        message.setType(1);

        return message;
    }
}
