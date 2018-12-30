package ru.myhabit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStartPage(){
        return "start";
    }
    @RequestMapping(value = "/user_manager", method = RequestMethod.GET)
    public String getUserManagerPage(){
        return "user_manager";
    }
}
