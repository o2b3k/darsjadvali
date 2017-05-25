package kg.ksucta.repository;

import kg.ksucta.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by o2b3k on 5/23/17.
 */
public interface MessageRepository extends JpaRepository<Message,Long>{
    List<Message> findByDatesIsStartingWith(Date date);
    
}
