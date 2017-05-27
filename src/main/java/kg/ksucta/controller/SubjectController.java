package kg.ksucta.controller;

import com.sun.jndi.toolkit.url.Uri;
import kg.ksucta.domain.model.Subject;
import kg.ksucta.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    /*----------- Retrieve All Subjects ------------------*/
    @RequestMapping(value = "/subject",method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> listResponseEntity(){
        List<Subject> subjects = subjectService.findAllSubjects();
        if (subjects.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Subject>>(subjects,HttpStatus.OK);
    }

    /*----------- Retrieve Single Subject ------------------*/
    @RequestMapping(value = "/subject/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getSubject(@PathVariable("id") Long id){
        Subject subject = subjectService.getById(id);
        if (subject == null){
            return new ResponseEntity(new CustomErrorType("Subject with id " + id
                    + " not found"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Subject>(subject,HttpStatus.OK);
    }
    /*----------- Create new Subject ------------------*/
    @RequestMapping(value = "/subject",method = RequestMethod.POST)
    public ResponseEntity<?> createSubject(@RequestBody Subject subject, UriComponentsBuilder builder){
        subjectService.saveSubject(subject);
        HttpHeaders headers =   new HttpHeaders();
        headers.setLocation(builder.path("/api/subject/{id}").buildAndExpand(subject.getId()).toUri());
        return new ResponseEntity<String>(headers,HttpStatus.CREATED);
    }

    /*------------Update subject -------------*/
    @RequestMapping(value = "/subject/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateSubject(@PathVariable("id") Long id,@RequestBody Subject subject){
        Subject currentSubject = subjectService.getById(id);
        if (currentSubject == null){
            return new ResponseEntity(new CustomErrorType("Unable to update. Subject with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        currentSubject.setTime(subject.getTime());
        currentSubject.setName(subject.getName());
        currentSubject.setRoom(subject.getRoom());
        currentSubject.setDay(subject.getDay());
        currentSubject.setActive(subject.getActive());
        subjectService.updateSubject(currentSubject);
        return new ResponseEntity<Subject>(currentSubject,HttpStatus.OK);
    }

    /*------------ Delete subject -----------------*/
    @RequestMapping(value = "/subject/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSubject(@PathVariable("id") Long id){
        Subject subject = subjectService.getById(id);
        if (subject == null){
            return new ResponseEntity(new CustomErrorType("Unable to delete. Subject with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        subjectService.deleteSubject(id);
        return new ResponseEntity<Subject>(HttpStatus.NO_CONTENT);
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
