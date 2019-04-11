package ru.wkn.repository.dao.h2;

import org.hibernate.Session;
import ru.wkn.entities.User;

import javax.persistence.Query;

public class UserH2Dao extends H2Dao<User, Integer> {


    public UserH2Dao(Class<User> entityClass, Session session) {
        super(entityClass, session);
    }

    public User logIn(String login, String password) {
        Query query = super.getSession()
                .createSQLQuery("SELECT * FROM user WHERE login = :login AND password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (User) query.getResultList().get(0);
    }

    public boolean isExistCookie(String cookie) {
        Query query = super.getSession()
                .createSQLQuery("SELECT cookie FROM user WHERE cookie = :cookie");
        query.setParameter("cookie", cookie);
        return query.getResultList().size() != 0;
    }
}
