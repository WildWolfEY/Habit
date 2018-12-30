package ru.myhabit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.myhabit.data.domain.*;
import ru.myhabit.data.services.*;

import java.util.Date;

@Controller
public class CrudController {
    @Autowired
    ApplicationContext context;
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



    @RequestMapping(value = "/create/area", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Area> createArea(@RequestParam String name){
        Cat serc=  (Cat)context.getBean("dd");
        System.out.println(serc);
        serc=  (Cat)context.getBean("dd");
        System.out.println(serc);
//        Area area = new Area();
//        area.setName(name);
//        try {
//            area = areaService.update(area);
//            return new ResponseEntity<Area>(area, HttpStatus.CREATED);
//        }
//        catch (Exception err)
//        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }
    @RequestMapping(value = "/create/area-habit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AreaHabit> createAreaHabit(@RequestParam Long idArea, @RequestParam Long idHabit){
        AreaHabit areaHabit = new AreaHabit();
        areaHabit.setArea(areaService.getById(idArea));
        areaHabit.setHabit(habitService.getById(idHabit));
        try {
            areaHabit = areaHabitService.update(areaHabit);
            return new ResponseEntity<AreaHabit>(areaHabit, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/create/habit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Habit> createHabit(@RequestParam String name){
        Habit habit = new Habit();
        habit.setName(name);
        try {
            habit = habitService.update(habit);
            return new ResponseEntity<Habit>(habit, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/create/archive", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Archive> createArchive(@RequestParam Long idHabit, @RequestParam Long idUser){
        Archive archive = new Archive();
        archive.setHabit(habitService.getById(idHabit));
        archive.setUser(userService.getById(idUser));
        archive.setDateEnd(new Date());
        try {
            archive = archiveService.update(archive);
            return new ResponseEntity<Archive>(archive, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/create/progress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Progress> createProgress(@RequestParam Long idUser, @RequestParam Long idStep, @RequestParam String progressTask){
        Progress progress = new Progress();
        progress.setUser(userService.getById(idUser));
        progress.setStep(stepService.getById(idStep));
        progress.setDateStart(new Date());
        try {
            progress = progressService.update(progress);
            return new ResponseEntity<Progress>(progress, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Deprecated
    @RequestMapping(value = "/create/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Status> createStatus(@RequestParam String name){
        Status status = new Status();
        status.setName(name);
        try {
            status = statusService.update(status);
            return new ResponseEntity<Status>(status, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/create/strategy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Strategy> createStrategy (@RequestParam Long idUser, @RequestParam Long idStep){
        Strategy strategy = new Strategy();
        strategy.setUser(userService.getById(idUser));
        strategy.setStep(stepService.getById(idStep));
        strategy.setProgressPercent(0);
        strategy.setDateStart(new Date());
        try {
            strategy = strategyService.update(strategy);
            return new ResponseEntity<Strategy>(strategy, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/create/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Test> createTest(@RequestParam String question, @RequestParam Long idHabit){
        Test test = new Test();
        test.setQuestion(question);
        test.setHabit(habitService.getById(idHabit));
        try {
            test = testService.update(test);
            return new ResponseEntity<Test>(test, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/create/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestParam String login){
        User user = new User();
        user.setLogin(login);
        try {
            user = userService.update(user);
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/create/test_step", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<VariantTestStep> createTestStep(@RequestParam String answer, @RequestParam Long idStep){
        VariantTestStep test = new VariantTestStep();
        test.setAnswer(answer);
        test.setStep(stepService.getById(idStep));
        try {
            test = variantTestStepService.update(test);
            return new ResponseEntity<VariantTestStep>(test, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/create/test_habit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<VariantTestHabit> createTestHabit(@RequestParam String answer, @RequestParam Long idHabit){
        VariantTestHabit test = new VariantTestHabit();
        test.setAnswer(answer);
        test.setHabit(habitService.getById(idHabit));
        try {
            test = variantTestHabitService.update(test);
            return new ResponseEntity<VariantTestHabit>(test, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update/area", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Area> updateArea(@RequestParam Area area){
        try {
            area = areaService.update(area);
            return new ResponseEntity<Area>(area, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/update/area-habit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AreaHabit> updateAreaHabit(@RequestParam AreaHabit areaHabit){
        try {
            areaHabit = areaHabitService.update(areaHabit);
            return new ResponseEntity<AreaHabit>(areaHabit, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update/habit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Habit> updateHabit(@RequestParam Habit habit){
        try {
            habit = habitService.update(habit);
            return new ResponseEntity<Habit>(habit, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/update/archive", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Archive>  updateArchive(@RequestParam Archive archive){
        try {
            archive = archiveService.update(archive);
            return new ResponseEntity<Archive>(archive, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update/progress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Progress> updateProgress(@RequestParam Progress progress){
        try {
            progress = progressService.update(progress);
            return new ResponseEntity<Progress>(progress, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Deprecated
    @RequestMapping(value = "/update/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Status> updateStatus(@RequestParam Status status){
        try {
            status = statusService.update(status);
            return new ResponseEntity<Status>(status, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/update/strategy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Strategy> updateStrategy (@RequestParam Strategy strategy){
        try {
            strategy = strategyService.update(strategy);
            return new ResponseEntity<Strategy>(strategy, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Test> updateTest(@RequestParam Test test){
        try {
            test = testService.update(test);
            return new ResponseEntity<Test>(test, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/update/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> updateUser(@RequestParam User user){
        try {
            user = userService.update(user);
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update/test_step", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<VariantTestStep> updateTestStep(@RequestParam VariantTestStep test){
       try {
            test = variantTestStepService.update(test);
            return new ResponseEntity<VariantTestStep>(test, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/update/test_habit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<VariantTestHabit> updateTestHabit(@RequestParam VariantTestHabit test){
       try {
            test = variantTestHabitService.update(test);
            return new ResponseEntity<VariantTestHabit>(test, HttpStatus.CREATED);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/area", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Area> deleteArea(@RequestParam Area area){
        try {
            areaService.delete(area);
            return new ResponseEntity<Area>(area, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/area-habit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AreaHabit> deleteAreaHabit(@RequestParam AreaHabit areaHabit){
        try {
            areaHabitService.delete(areaHabit);
            return new ResponseEntity<AreaHabit>(areaHabit, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/habit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Habit> deleteHabit(@RequestParam Habit habit){
        try {
            habitService.delete(habit);
            return new ResponseEntity<Habit>(habit, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/delete/archive", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Archive>  deleteArchive(@RequestParam Archive archive){
        try {
            archiveService.delete(archive);
            return new ResponseEntity<Archive>(archive, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/progress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Progress> deleteProgress(@RequestParam Progress progress){
        try {
            progressService.delete(progress);
            return new ResponseEntity<Progress>(progress, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Deprecated
    @RequestMapping(value = "/delete/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Status> deleteStatus(@RequestParam Status status){
        try {
            statusService.delete(status);
            return new ResponseEntity<Status>(status, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/delete/strategy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Strategy> deleteStrategy (@RequestParam Strategy strategy){
        try {
            strategyService.delete(strategy);
            return new ResponseEntity<Strategy>(strategy, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Test> deleteTest(@RequestParam Test test){
        try {
            testService.delete(test);
            return new ResponseEntity<Test>(test, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/delete/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> deleteUser(@RequestParam User user){
        try {
            userService.delete(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/test_step", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<VariantTestStep> deleteTestStep(@RequestParam VariantTestStep test){
        try {
            variantTestStepService.delete(test);
            return new ResponseEntity<VariantTestStep>(test, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/delete/test_habit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<VariantTestHabit> deleteTestHabit(@RequestParam VariantTestHabit test){
        try {
            variantTestHabitService.delete(test);
            return new ResponseEntity<VariantTestHabit>(test, HttpStatus.OK);
        }
        catch (Exception err)
        {
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
