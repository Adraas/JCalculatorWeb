package ru.wkn.repository.dao;

import ru.wkn.entities.Operation;
import ru.wkn.repository.GeneralDao;
import ru.wkn.repository.IDao;

import java.util.List;

public class OperationDao implements IDao<Operation, Integer> {

    private GeneralDao<Operation, Integer> generalDao;

    public OperationDao(GeneralDao<Operation, Integer> generalDao) {
        this.generalDao = generalDao;
    }

    @Override
    public void create(Operation newOperation) {
        generalDao.create(newOperation);
    }

    @Override
    public Operation read(Integer index) {
        return generalDao.read(index);
    }

    @Override
    public void update(Operation transientOperation) {
        generalDao.update(transientOperation);
    }

    @Override
    public void delete(Operation transientOperation) {
        generalDao.delete(transientOperation);
    }

    @Override
    public List<Operation> getAll() {
        return generalDao.getAll("operation");
    }
}
