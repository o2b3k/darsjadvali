package kg.ksucta.service;

import kg.ksucta.domain.model.Subject;


import java.util.List;

/**
 * Created by o2b3k on 5/23/17.
 */

public interface SubjectService {
    List<Subject> getByName(String lesson);
    List<Subject> getByDay(String day);
    List<Subject> findAllSubjects();
    Subject getById(Long id);

    void saveSubject(Subject subject);
    void updateSubject(Subject subject);
    void deleteSubject(Long id);

}
