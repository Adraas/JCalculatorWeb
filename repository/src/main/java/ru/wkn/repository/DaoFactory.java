package ru.wkn.repository;

import org.hibernate.Session;
import ru.wkn.entities.Operation;
import ru.wkn.entities.User;
import ru.wkn.repository.h2.H2OperationDao;
import ru.wkn.repository.h2.H2UserDao;

public class DaoFactory<V, I> implements IDaoFactory<V, I> {

    @Override
    public IDao<V, I> createDao(String database, Class<V> entityClass, Session session) {
        switch (database) {
            case "h2": {
                return entityClass.equals(User.class) ? (IDao<V, I>) new H2UserDao(session)
                        : entityClass.equals(Operation.class) ? (IDao<V, I>) new H2OperationDao(session)
                        : null;
            }
            default: {
                return null;
            }
        }
    }
}
