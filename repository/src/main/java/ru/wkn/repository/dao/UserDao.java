package ru.wkn.repository.dao;

import ru.wkn.entities.User;
import ru.wkn.repository.GeneralDao;
import ru.wkn.repository.IDao;

import java.util.List;

public class UserDao implements IDao<User, Integer> {

    private GeneralDao<User, Integer> generalDao;

    public UserDao(GeneralDao<User, Integer> generalDao) {
        this.generalDao = generalDao;
    }

    @Override
    public void create(User newUser) {
        generalDao.create(newUser);
    }

    @Override
    public User read(Integer index) {
        return generalDao.read(index);
    }

    @Override
    public void update(User transientUser) {
        generalDao.update(transientUser);
    }

    @Override
    public void delete(User transientUser) {
        generalDao.delete(transientUser);
    }

    @Override
    public List<User> getAll() {
        return generalDao.getAll("user");
    }
}
