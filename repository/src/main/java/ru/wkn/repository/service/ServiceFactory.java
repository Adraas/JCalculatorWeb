package ru.wkn.repository.service;

import ru.wkn.entities.Operation;
import ru.wkn.entities.User;
import ru.wkn.repository.dao.IDao;

public class ServiceFactory implements IServiceFactory {

    @Override
    public IService createService(IDao iDao) {
        Class entityClass = iDao.getEntityClass();
        return entityClass.equals(User.class) ? new UserService(iDao)
                : entityClass.equals(Operation.class) ? new OperationService(iDao)
                : null;
    }
}
