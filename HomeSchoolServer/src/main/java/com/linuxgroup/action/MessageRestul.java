package com.linuxgroup.action;

import com.linuxgroup.model.Message;
import com.linuxgroup.service.MessageService;
import com.linuxgroup.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/message")
public class MessageRestul {

    @Autowired()
    private MessageService messageService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Message get(HttpServletRequest request, HttpServletResponse response,
                    @PathVariable Integer id) {


        //TODO: 测试样例
        /*Message message = new Message();

        message.setContent("小测试 娃哈哈");
        message.setFromAccount("18369905136");
        message.setToAccount("18369905506");
        message.setTime(new Date());
        message.setType(1);

        Integer mesId = messageService.saveMessage(message);*/

        Message message = messageService.get(id);

        return message;
    }

    


    // set and get methods


    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
