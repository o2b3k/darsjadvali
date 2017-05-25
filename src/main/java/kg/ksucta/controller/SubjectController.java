package kg.ksucta.controller;

import kg.ksucta.domain.model.Subject;
import kg.ksucta.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by o2b3k on 5/23/17.
 */
@RestController
@RequestMapping("/api")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    private void setSubjectService(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @RequestMapping(value = "/subject/{lesson}",method = RequestMethod.GET)
    public List<Subject> getByLesson(@PathVariable("lesson") String lesson){
        List<Subject> subjectServiceByName = subjectService.getByName(lesson);
        return subjectServiceByName;
    }

    @RequestMapping(value = "/subject/{day}", method = RequestMethod.GET)
    public List<Subject> getByDayOfWeeks(@PathVariable("day") String day){
        List<Subject> subjectServiceByDay = subjectService.getByDay(day);
        return subjectServiceByDay;
    }

}
