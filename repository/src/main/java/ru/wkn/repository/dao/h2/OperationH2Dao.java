package ru.wkn.repository.dao.h2;

import org.hibernate.Session;
import ru.wkn.entities.Operation;

public class OperationH2Dao extends H2Dao<Operation, Integer> {

    public OperationH2Dao(Class<Operation> entityClass, Session session) {
        super(entityClass, session);
    }
}
