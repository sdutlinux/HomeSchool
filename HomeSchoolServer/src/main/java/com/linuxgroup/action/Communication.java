package com.linuxgroup.action;

import com.linuxgroup.model.Class;
import com.linuxgroup.model.Person;
import com.linuxgroup.service.ClassService;
import com.linuxgroup.service.MessageService;
import com.linuxgroup.service.PersonService;
import com.linuxgroup.service.PushService;
import net.sf.json.JSONObject;
import com.linuxgroup.result.Result;
import com.opensymphony.xwork2.Action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by tan on 14-9-20.
 */
public class Communication {

    private PushService pushService;
    private MessageService messageService;
    private PersonService personService;
    private ClassService classService;
    private JSONObject jsonObj;

    public String sendMessage() {

        Result result = new Result();

        /**
         *  创建一个Message对象
         */
        //ChatMessage msg = new ChatMessage();
//        Person person = new Person();
//
//        person.setAccount("1836944444444444449");
//        person.setPassword("0000444444444444");
//        person.setAddress("zibo");
//        person.setName("huihui");
//        person.setSex(0);
//        person.setCommunication("183699");
//        person.setType(1);
//
//        Integer id = personService.savePerson(person);
//        System.out.println(id);
//        System.out.println(person);

//        ChatMessage chatMsg = new ChatMessage();
//        chatMsg.setContent("test");
//        chatMsg.setToAccount("1001");
//        chatMsg.setFromAccount("1002");
//        chatMsg.setType(1);
//
//        messageService.saveMessage(chatMsg);
//
//        System.out.println(chatMsg);
//
//        //messageService.saveMessage(chatMsg);
//        //ChatMessage ch = (ChatMessage)messageService.get(1);
//        //System.out.println(ch.getFromAccount() + " "+ " " + ch.getToAccount());
//
//        List<Message> chat = messageService.findByType(1);
//
//        for(int i = 0;i < chat.size();i++) {
//            Message message = chat.get(i);
//            ChatMessage chatMessage = (ChatMessage) message;
//            System.out.println(chatMessage);
//
////            System.out.println(chat.get(i).getId());
//        }


        /*try {
            pushService.pushToAll("person存储");  // 将信息发送至极光推送
            result.setStatus("ok");

        } catch (Exception e) {

            result.setStatus("error");

        }

        jsonObj = JsonUtils.toJson(result);*/

//        Person person = personService.getPerson(1);
//
////        System.out.println(person);

//        Class classes = new Class();
//
//        classes.setClassName("四年级一班");
//        classes.setClassNum("4#01");
//
//        Person person1 = new Person(1,"1001","Tom",1,"US","10001",1);
//        Person person2 = new Person(2,"2001","Jerry",2,"US","20001",1);
//
//        Set<Person> persons = new HashSet<Person>();
//        persons.add(person1);
//        persons.add(person2);
//
//        classes.setPersons(persons);
//
//        personService.savePerson(person1);
//        personService.savePerson(person2);
//
//        System.out.println(classes);
//
//        classService.save(classes);

//        List<String> classNum;
//        classNum = classService.findClassNum();
//
//        Iterator iterator = classNum.iterator();
//
//        while (iterator.hasNext()) {
//
//            System.out.println(iterator.next());
//        }
//
//        return Action.SUCCESS;
//    }

//        List<String> className;
//        className = classService.findClassName();
//
//        Iterator iterator = className.iterator();
//
//        while (iterator.hasNext()) {
//
//            System.out.println(iterator.next());
//        }

//        List<Person> classPerson;
//        classPerson = classService.findClassPerson("四年级一班");
//
//        Iterator iterator = classPerson.iterator();
//
//        while (iterator.hasNext()) {
//
//            System.out.println(iterator.next());
//        }


        return Action.SUCCESS;
    }

    // set and get methods


    public ClassService getClassService() {
        return classService;
    }

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

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
