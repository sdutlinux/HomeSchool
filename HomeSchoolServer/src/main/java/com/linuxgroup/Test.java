package com.linuxgroup;

import com.google.gson.Gson;
import com.linuxgroup.dao.ClassDao;
import com.linuxgroup.model.ChatMessage;
import com.linuxgroup.model.Message;
import com.linuxgroup.result.Result;
import com.linuxgroup.service.impl.MessageServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        //System.out.println("1.0.0".compareTo("0.0.9"));
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassDao classDao = ctx.getBean("classDao", ClassDao.class);
        System.out.println(classDao.findBy("1"));
    }
}

