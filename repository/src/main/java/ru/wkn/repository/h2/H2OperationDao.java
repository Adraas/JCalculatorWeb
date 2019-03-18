package ru.wkn.repository.h2;

import org.hibernate.Session;
import ru.wkn.entities.Operation;
import ru.wkn.repository.IDao;

import java.util.List;

public class H2OperationDao implements IDao<Operation, Integer> {

    private Session session;

    public H2OperationDao(Session session) {
        this.session = session;
    }

    @Override
    public void create(Operation newInstance) {
    }

    @Override
    public Operation read(Integer index) {
        return null;
    }

    @Override
    public void update(Operation transientInstance) {
    }

    @Override
    public void delete(Operation transientInstance) {
    }

    @Override
    public List<Operation> getAll() {
        return null;
    }
}
