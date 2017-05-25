package kg.ksucta.repository;

import kg.ksucta.domain.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by o2b3k on 5/23/17.
 */

public interface SubjectRepository extends JpaRepository<Subject,Long>{
    List<Subject> findByDay(String day);
    List<Subject> findByName(String lesson);
    List<Subject> findSubjectById(Long id);
}
