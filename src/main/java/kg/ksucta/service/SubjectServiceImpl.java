package kg.ksucta.service;

import io.jsonwebtoken.lang.Assert;
import kg.ksucta.domain.model.Subject;
import kg.ksucta.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by o2b3k on 5/23/17.
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private static final AtomicLong counter = new AtomicLong();
    public SubjectServiceImpl(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    private static List<Subject> subjects;
    @Override
    public List<Subject> getByName(String lesson) {
        Assert.notNull(lesson,"Lesson must not be empty!!!");
        for (Subject subject : subjects){
            if (subject.getName().equalsIgnoreCase(lesson)){
                return (List<Subject>) subject;
            }
        }
        return null;
    }

    @Override
    public List<Subject> getByDay(String day) {
        Assert.notNull(day,"Day must not be empty!!!");
        for (Subject subject : subjects){
            if (subject.getDay().equalsIgnoreCase(day)){
                return (List<Subject>) subject;
            }
        }
        return null;
    }

    @Override
    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getById(Long id) {
        for (Subject subject : subjects){
            if (subject.getId() == id){
                return subject;
            }
        }
        return null;
    }


    @Override
    public void saveSubject(Subject subject) {
        subject.setId(counter.incrementAndGet());
        subjects.add(subject);
        subjectRepository.save(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        int index = subjects.indexOf(subject);
        subjects.set(index,subject);
    }

    @Override
    public void deleteSubject(Long id) {
        for (Iterator<Subject> iterator = subjects.iterator();iterator.hasNext();){
            Subject subject = iterator.next();
            if (subject.getId() == id){
                subjectRepository.delete(id);
            }
        }
    }


}
