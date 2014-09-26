package com.linuxgroup.action;

import com.linuxgroup.model.Message;
import com.linuxgroup.model.Person;
import com.linuxgroup.service.MessageService;
import com.linuxgroup.service.PersonService;
import com.linuxgroup.service.PushService;
import net.sf.json.JSON;
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
    private MessageService messageService;
    private PersonService personService;
    private JSONObject jsonObj;


    public String sendMessage() {

        Result result = new Result();

        /**
         *  创建一个Message对象
         */
        //Message msg = new Message();
        Person person = new Person();

        person.setAccount("1836944444444444449");
        person.setPassword("0000444444444444");
        person.setAddress("zibo");
        person.setName("huihui");
        person.setSex(0);
        person.setCommunication("183699");
        person.setType(1);


        System.out.println(personService);


        Integer id = personService.savePerson(person);
        System.out.println(id);

        person.setName("hhhhh");
        personService.updatePerson(person);
        //personService.deletePerson(2);
        //Person p = personService.getPerson(1);
        //System.out.println(p);
        //System.out.println( personService.personFindBy("183699").getId() );
        //System.out.println(p.getId());



        try {

            //jsonObj = JSONObject.fromObject(str);
            //msg  = JSONObject.toBean(jsonObj,Message.class);
            //messageService.saveMessage(msg);
            //Integer id = messageService


            pushService.pushToAll("person存储");  // 将信息发送至极光推送
            result.setStatus("ok");

        } catch (Exception e) {

            result.setStatus("error");

        }

        jsonObj = JsonUtils.toJson(result);

        return Action.SUCCESS;
    }


    // set and get methods


    public PushService getPushService() {
        return pushService;
    }

    public void setPushService(PushService pushService) {
        this.pushService = pushService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public JSONObject getJsonObj() {
        return jsonObj;
    }

    public void setJsonObj(JSONObject jsonObj) {
        this.jsonObj = jsonObj;
    }
}
