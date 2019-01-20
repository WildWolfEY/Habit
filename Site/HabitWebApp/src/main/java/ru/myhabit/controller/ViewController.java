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
        return "manager/user_manager";
    }
    @RequestMapping(value = "/habit_manager", method = RequestMethod.GET)
    public String getHabitManagerPage(){
        return "manager/habit_manager";
    }
    @RequestMapping(value = "/area_manager", method = RequestMethod.GET)
    public String getAreaManagerPage(){
        return "manager/area_manager";
    }
    @RequestMapping(value = "/area_habit_manager", method = RequestMethod.GET)
    public String getAreaHabitManagerPage(){
        return "manager/area_habit_manager";
    }
}
