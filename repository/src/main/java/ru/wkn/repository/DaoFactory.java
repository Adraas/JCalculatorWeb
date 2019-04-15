package ru.wkn.repository;

import org.hibernate.Session;
import ru.wkn.entities.Operation;
import ru.wkn.entities.User;
import ru.wkn.repository.dao.h2.H2Dao;
import ru.wkn.repository.dao.h2.OperationH2Dao;
import ru.wkn.repository.dao.h2.UserH2Dao;

public class DaoFactory<V, I> implements IDaoFactory<V, I> {

    @Override
    public IDao createDao(Class<IDao<V, I>> daoClass, Class<V> entityClass, Session session) {
        return daoClass.equals(H2Dao.class) ?
                entityClass.equals(User.class) ? new UserH2Dao(User.class, session)
                        : entityClass.equals(Operation.class) ? new OperationH2Dao(Operation.class, session)
                        : null
                : null;
    }
}
