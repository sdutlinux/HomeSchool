package com.linuxgroup.action;

import com.linuxgroup.model.Person;
import com.linuxgroup.result.Result;
import com.linuxgroup.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserRestful {
    @Autowired
    private PersonService personService;

    //todo: 没有检测用户名是否存在
    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody Result register(@RequestBody Person person) {
        Integer personId = personService.savePerson(person);

        Result result = new Result();
        result.setStatus("ok");
        result.setRetId(personId);

        return result;
    }

    /**
     * todo 接口暂且这样搞
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/login/{account}/{password}", method = RequestMethod.GET)
    public @ResponseBody Result login(@PathVariable String account, @PathVariable String password) {
        System.out.println("account:" + account + " password:" + password);

        Person person = personService.login(account, password);

        Result result = new Result();

        if (person == null) {
            result.setStatus("error");
            result.setErrorDesc("账户或密码错误");
        } else {
            result.setStatus("ok");
            result.setPerson(person);
        }

        return result;
    }

    /**
     * todo: 搜索，会增加模糊搜索
     * @param account
     * @return
     */
    @RequestMapping(value = "/search/{account}", method = RequestMethod.GET)
    public @ResponseBody Person search(@PathVariable String account) {
        Person person = personService.findBy(account);

        return person;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Person userInfo(@PathVariable Integer id) {
        Person person = personService.getPerson(id);
        System.out.println("获取好友信息: " + person);
        return person;
    }

    @RequestMapping(value = "/account/{account}", method = RequestMethod.GET)
    public @ResponseBody Person userInfo(@PathVariable String account) {
        Person person = personService.getPerson(account);
        System.out.println("获取好友信息: " + person);
        return person;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
