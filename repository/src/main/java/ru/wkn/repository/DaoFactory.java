package ru.wkn.repository;

import org.hibernate.Session;
import ru.wkn.repository.dao.H2Dao;

public class DaoFactory<V, I> implements IDaoFactory<V, I> {

    @Override
    public IDao<V, I> createDao(Class<IDao<V, I>> daoClass, Class<V> entityClass, Session session) {
        return daoClass.equals(H2Dao.class) ? new H2Dao<>(entityClass, session)
            : null;
    }
}
