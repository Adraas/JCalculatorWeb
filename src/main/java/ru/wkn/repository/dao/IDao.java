package ru.wkn.repository.dao;

import ru.wkn.repository.PersistenceException;

public interface IDao<V, I> {

    V create(V newInstance) throws PersistenceException;

    V read(I index) throws PersistenceException;

    void update(V transientInstance) throws PersistenceException;

    void delete(V transientInstance) throws PersistenceException;
}
