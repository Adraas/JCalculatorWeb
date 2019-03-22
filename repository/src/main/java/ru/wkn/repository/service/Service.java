package ru.wkn.repository.service;

import ru.wkn.repository.IDao;
import ru.wkn.repository.IService;

import java.util.List;

public class Service<V, I> implements IService<V, I> {

    private IDao<V, I> iDao;

    public Service(IDao<V, I> iDao) {
        this.iDao = iDao;
    }

    @Override
    public void create(V newInstance) {
        iDao.create(newInstance);
    }

    @Override
    public V read(I index) {
        return iDao.read(index);
    }

    @Override
    public void update(V transientInstance) {
        iDao.update(transientInstance);
    }

    @Override
    public void delete(V transientInstance) {
        iDao.delete(transientInstance);
    }

    @Override
    public List<V> getAll() {
        return iDao.getAll();
    }
}
