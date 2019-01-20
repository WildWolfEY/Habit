package ru.myhabit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.myhabit.data.domain.*;
import ru.myhabit.data.services.*;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    AreaService areaService;
    @Autowired
    HabitService habitService;
    @Autowired
    AreaHabitService areaHabitService;
    @Autowired
    ArchiveService archiveService;
    @Autowired
    ProgressService progressService;
    @Autowired
    StatusService statusService;
    @Autowired
    StepService stepService;
    @Autowired
    StrategyService strategyService;
    @Autowired
    TestService testService;
    @Autowired
    UserService userService;
    @Autowired
    VariantTestStepService variantTestStepService;
    @Autowired
    VariantTestHabitService variantTestHabitService;

    @RequestMapping(value = "/search-all/area", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Area> searchAllArea(){
        try {
            List<Area> areas  = areaService.getAll();
            return new ResponseEntity(areas, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/search-all/area-habit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<AreaHabit> searchAllAreaHabit(){
        try {
            List<AreaHabit> areaHabits = areaHabitService.getAll();
            return new ResponseEntity(areaHabits, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/search-all/habit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Habit> searchAllHabit(){
        try {
            List<Habit> habits = habitService.getAll();
            return new ResponseEntity(habits, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/search-all/archive", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Archive>  searchAllArchive(){
        try {
            List<Archive> archives = archiveService.getAll();
            return new ResponseEntity(archives, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/search-all/progress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Progress> searchAllProgress(){
        try {
            List<Progress> progresses = progressService.getAll();
            return new ResponseEntity(progresses, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Deprecated
    @RequestMapping(value = "/search-all/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Status> searchAllStatus(){
        try {
            List<Status> statuses = statusService.getAll();
            return new ResponseEntity(statuses, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/search-all/strategy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Strategy> searchAllStrategy (){
        try {
            List<Strategy> strategies = strategyService.getAll();
            return new ResponseEntity(strategies, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/search-all/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Test> searchAllTest(){
        try {
            List<Test> tests = testService.getAll();
            return new ResponseEntity(tests, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/search-all/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<User> searchAllUser(){
        try {
            List<User> users = userService.getAll();
            return new ResponseEntity(users, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/search-all/test_step", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<VariantTestStep> searchAllTestStep(){
        try {
            List<VariantTestStep> tests = variantTestStepService.getAll();
            return new ResponseEntity(tests, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/search-all/test_habit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<VariantTestHabit> searchAllTestHabit(){
        try {
            List<VariantTestHabit> tests = variantTestHabitService.getAll();
            return new ResponseEntity(tests, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
