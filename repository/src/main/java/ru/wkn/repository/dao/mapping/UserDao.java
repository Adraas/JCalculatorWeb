package ru.wkn.repository.dao.mapping;

import ru.wkn.entities.User;
import ru.wkn.repository.PersistenceException;
import ru.wkn.repository.dao.IDao;

import java.util.List;

public class UserDao implements IDao<User, Integer> {

    @Override
    public User create(User newInstance) throws PersistenceException {
        return null;
    }

    @Override
    public User read(Integer index) throws PersistenceException {
        return null;
    }

    @Override
    public void update(User transientInstance) throws PersistenceException {
    }

    @Override
    public void delete(User transientInstance) throws PersistenceException {
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
