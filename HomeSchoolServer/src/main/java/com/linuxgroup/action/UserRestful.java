package com.linuxgroup.action;

import com.linuxgroup.model.Person;
import com.linuxgroup.result.Result;
import com.linuxgroup.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserRestful {
    @Autowired
    private PersonService personService;

    //todo: 没有检测用户名是否存在
    @RequestMapping(value = "/register", method = RequestMethod.POST)
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

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
