package ru.wkn.repository.dao.h2;

import org.hibernate.Session;
import ru.wkn.entities.User;

import javax.persistence.Query;
import java.util.List;

public class UserH2Dao extends H2Dao<User, Integer> {


    public UserH2Dao(Class<User> entityClass, Session session) {
        super(entityClass, session);
    }

    public User logIn(String login, String password) {
        Query query = super.getSession()
                .createNativeQuery("SELECT full_name, login, password, cookie FROM user WHERE login LIKE(:login)"
                        .concat("AND password LIKE(:password)"));
        query.setParameter("login", login);
        query.setParameter("password", password);
        List resultList = query.getResultList();
        if (resultList.size() == 1) {
            Object[] result = (Object[]) query.getResultList().get(0);
            return new User(result[0].toString(), result[1].toString(), result[2].toString(), result[3].toString());
        }
        return null;
    }

    public boolean isExistCookie(String cookie) {
        Query query = super.getSession()
                .createNativeQuery("SELECT cookie FROM user WHERE cookie LIKE(:cookie)");
        query.setParameter("cookie", cookie);
        return query.getResultList().size() != 0;
    }
}
