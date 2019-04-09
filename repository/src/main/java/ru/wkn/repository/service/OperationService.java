package ru.wkn.repository.service;

import ru.wkn.entities.Operation;
import ru.wkn.repository.IDao;

public class OperationService extends Service<Operation, Integer> {

    public OperationService(IDao<Operation, Integer> iDao) {
        super(iDao);
    }
}
