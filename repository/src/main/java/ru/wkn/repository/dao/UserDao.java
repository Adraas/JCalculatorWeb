package ru.wkn.repository.dao;

import ru.wkn.entities.User;
import ru.wkn.repository.IDao;
import ru.wkn.repository.dao.h2.H2Dao;

import java.util.List;

public class UserDao implements IDao<User, Integer> {

    private H2Dao<User, Integer> h2Dao;

    public UserDao(H2Dao<User, Integer> h2Dao) {
        this.h2Dao = h2Dao;
    }

    @Override
    public void create(User newUser) {
        h2Dao.create(newUser);
    }

    @Override
    public User read(Integer index) {
        return h2Dao.read(index);
    }

    @Override
    public void update(User transientUser) {
        h2Dao.update(transientUser);
    }

    @Override
    public void delete(User transientUser) {
        h2Dao.delete(transientUser);
    }

    @Override
    public List<User> getAll() {
        return h2Dao.getAll("user");
    }
}
