package ru.wkn.repository;

import org.hibernate.Session;
import ru.wkn.entities.Operation;
import ru.wkn.entities.User;
import ru.wkn.repository.dao.OperationDao;
import ru.wkn.repository.dao.UserDao;
import ru.wkn.repository.dao.h2.H2Dao;

public class DaoFactory<V, I> implements IDaoFactory<V, I> {

    @Override
    public IDao<V, I> createDao(String database, Class<V> entityClass, Session session) {
        GeneralDao generalDao = createGeneralDao(database, entityClass, session);
        return entityClass.equals(User.class) ? (IDao<V, I>) new UserDao((H2Dao<User, Integer>) generalDao)
            : entityClass.equals(Operation.class) ? (IDao<V, I>) new OperationDao((H2Dao<Operation, Integer>) generalDao)
            : null;
    }

    private GeneralDao createGeneralDao(String database, Class<V> entityClass, Session session) {
        return database.equals("h2") ? new H2Dao<>(entityClass, session) : null;
    }
}
