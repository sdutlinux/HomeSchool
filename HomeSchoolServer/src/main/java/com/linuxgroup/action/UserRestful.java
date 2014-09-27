package com.linuxgroup.action;

import com.linuxgroup.model.Person;
import com.linuxgroup.result.Result;
import com.linuxgroup.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
    public @RequestMapping Person login() {


    }*/

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
