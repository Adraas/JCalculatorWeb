package ru.wkn.repository.dao;

import ru.wkn.entities.Operation;
import ru.wkn.repository.IDao;
import ru.wkn.repository.dao.h2.H2Dao;

import java.util.List;

public class OperationDao implements IDao<Operation, Integer> {

    private H2Dao<Operation, Integer> h2Dao;

    public OperationDao(H2Dao<Operation, Integer> h2Dao) {
        this.h2Dao = h2Dao;
    }

    @Override
    public void create(Operation newOperation) {
        h2Dao.create(newOperation);
    }

    @Override
    public Operation read(Integer index) {
        return h2Dao.read(index);
    }

    @Override
    public void update(Operation transientOperation) {
        h2Dao.update(transientOperation);
    }

    @Override
    public void delete(Operation transientOperation) {
        h2Dao.delete(transientOperation);
    }

    @Override
    public List<Operation> getAll() {
        return h2Dao.getAll("operation");
    }
}
