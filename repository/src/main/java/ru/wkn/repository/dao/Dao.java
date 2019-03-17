package ru.wkn.repository.dao;

import ru.wkn.repository.PersistenceException;

import java.util.List;

public class Dao<V, I> implements IDao<V, I> {

    @Override
    public V create(V newInstance) throws PersistenceException {
        return null;
    }

    @Override
    public V read(I index) throws PersistenceException {
        return null;
    }

    @Override
    public void update(V transientInstance) throws PersistenceException {
    }

    @Override
    public void delete(V transientInstance) throws PersistenceException {
    }

    @Override
    public List<V> getAll() {
        return null;
    }
}
