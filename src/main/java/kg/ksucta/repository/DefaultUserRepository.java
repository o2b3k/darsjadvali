package kg.ksucta.repository;

import kg.ksucta.domain.user.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Aibek Isaev on 06.01.2017.
 */
@Repository
public class DefaultUserRepository extends BaseCustomRepository implements CustomUserRepository {

    public DefaultUserRepository() {
        super(User.class);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("email", email));
        return (Optional<User>) criteria.uniqueResult();
    }
}
