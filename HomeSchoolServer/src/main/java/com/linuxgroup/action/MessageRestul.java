package com.linuxgroup.action;

import com.linuxgroup.model.ChatMessage;
import com.linuxgroup.result.Result;
import com.linuxgroup.service.MessageService;
import com.linuxgroup.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    ChatMessage get(HttpServletRequest request, HttpServletResponse response,
                    @PathVariable Integer id) {

        ChatMessage chatMessage = messageService.get(id);

        return chatMessage;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Result sendMessage(@RequestBody ChatMessage chatMessage) {
        Integer msgId = messageService.saveMessage(chatMessage);

        Result result = new Result();

        //todo: 修改为对指定用户发送消息
        try {
            // 推送消息的 id
            pushService.pushMessageToAll(""+msgId);

            result.setStatus("ok");
            result.setRetId(msgId);
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
