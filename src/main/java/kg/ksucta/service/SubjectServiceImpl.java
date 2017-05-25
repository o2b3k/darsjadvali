package kg.ksucta.service;

import io.jsonwebtoken.lang.Assert;
import kg.ksucta.domain.model.Subject;
import kg.ksucta.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by o2b3k on 5/23/17.
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getByName(String lesson) {
        Assert.notNull(lesson,"Lesson must not be empty!!!");
        return subjectRepository.findByName(lesson);
    }

    @Override
    public List<Subject> getByDay(String day) {
        Assert.notNull(day,"Day must not be empty!!!");
        return subjectRepository.findByDay(day);
    }

    @Override
    public List<Subject> getById(Long id) {
        Assert.notNull(id,"Id must not be empty!");
        return subjectRepository.findSubjectById(id);
    }
}
