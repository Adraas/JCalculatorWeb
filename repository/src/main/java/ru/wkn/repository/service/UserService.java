package ru.wkn.repository.service;

import ru.wkn.entities.User;
import ru.wkn.repository.IDao;
import ru.wkn.repository.dao.h2.UserH2Dao;

public class UserService extends Service<User, Integer> {

    public UserService(IDao<User, Integer> iDao) {
        super(iDao);
    }

    public User logIn(String login, String password) {
        return ((UserH2Dao) super.getDao()).logIn(login, password);
    }
}
