package kg.ksucta.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Aibek Isaev on 06.01.2017.
 */
@Repository
public abstract class BaseCustomRepository {

    protected Class aClass;

    @PersistenceContext
    private EntityManager entityManager;

    public BaseCustomRepository(Class aClass) {
        this.aClass =  aClass;
    }

    public Criteria getCriteria(){
        Session session = entityManager.unwrap(Session.class);
        return session.createCriteria(aClass);
    }
}
