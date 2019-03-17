package ru.wkn.repository.dao.mapping;

import ru.wkn.entities.Operation;
import ru.wkn.repository.PersistenceException;
import ru.wkn.repository.dao.IDao;

import java.util.List;

public class OperationDao implements IDao<Operation, Integer> {

    @Override
    public Operation create(Operation newInstance) throws PersistenceException {
        return null;
    }

    @Override
    public Operation read(Integer index) throws PersistenceException {
        return null;
    }

    @Override
    public void update(Operation transientInstance) throws PersistenceException {
    }

    @Override
    public void delete(Operation transientInstance) throws PersistenceException {
    }

    @Override
    public List<Operation> getAll() {
        return null;
    }
}
