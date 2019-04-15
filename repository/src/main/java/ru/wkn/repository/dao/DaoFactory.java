package ru.wkn.repository.dao;

import org.hibernate.Session;
import ru.wkn.entities.EntityType;
import ru.wkn.entities.Operation;
import ru.wkn.entities.User;
import ru.wkn.repository.dao.h2.OperationH2Dao;
import ru.wkn.repository.dao.h2.UserH2Dao;

public class DaoFactory implements IDaoFactory {

    @Override
    public IDao createDao(DaoType daoType, EntityType entityType, Session session) {
        return daoType.equals(DaoType.H2DAO) ?
                entityType.equals(EntityType.USER) ? new UserH2Dao(User.class, session)
                        : entityType.equals(EntityType.OPERATION) ? new OperationH2Dao(Operation.class, session)
                        : null
                : null;
    }
}
