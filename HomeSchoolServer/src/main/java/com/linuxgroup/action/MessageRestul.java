package com.linuxgroup.action;

import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import com.linuxgroup.model.Message;
import com.linuxgroup.result.Result;
import com.linuxgroup.service.MessageService;
import com.linuxgroup.service.PushService;
import com.linuxgroup.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private MessageService messageService;

    @Autowired
    private PushService pushService;

    /**
     * 获取消息
     * @param id 要获取的 id
     * @return 消息实体
     */
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

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Result sendMessage(@RequestBody Message message) {
        System.out.println(message.getContent() + " " + message.getFromAccount());

        Integer msgId = messageService.saveMessage(message);

        Result result = new Result();

        //todo: 修改为对指定用户发送消息
        try {
            // 推送消息的 id
            pushService.pushMessageToAll(""+msgId);

            result.setStatus("ok");
            result.setMessageId(msgId);
        } catch (Exception  e) {
            result.setStatus("error");
        }

        return result;
    }


    // set and get methods


    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public PushService getPushService() {
        return pushService;
    }

    public void setPushService(PushService pushService) {
        this.pushService = pushService;
    }
}
