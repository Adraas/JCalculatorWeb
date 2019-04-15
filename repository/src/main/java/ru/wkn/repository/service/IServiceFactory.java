package ru.wkn.repository.service;

import ru.wkn.repository.dao.IDao;

public interface IServiceFactory {

    public IService createService(IDao iDao);
}
