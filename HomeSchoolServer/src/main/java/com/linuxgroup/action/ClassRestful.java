package com.linuxgroup.action;

import com.linuxgroup.model.*;
import com.linuxgroup.model.Class;
import com.linuxgroup.result.Result;
import com.linuxgroup.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tan on 14-10-28.
 */
@Controller
@RequestMapping("/class")
public class ClassRestful {
    @Autowired
    private ClassService classService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody
    Result createClass(@RequestBody Class clas) {
        Integer classId = classService.save(clas);

        Result result = new Result();
        result.setStatus("ok");
        result.setRetId(classId);

        System.out.println("ClassRestFul: createClass: " + clas);

        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Class getClass(@PathVariable Integer id) {

        Class clas = classService.get(id);

        System.out.println("ClassRestFul: getClass: " + clas);

        return clas;
    }

    @RequestMapping(value = "/find/className/{className}", method = RequestMethod.GET)
    public @ResponseBody
    List<Class> findClass(@PathVariable String className) {
        List<Class> classes = classService.findBy(className);
        return classes;
    }

    //set and get methods

    public ClassService getClassService() {
        return classService;
    }

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }
}
