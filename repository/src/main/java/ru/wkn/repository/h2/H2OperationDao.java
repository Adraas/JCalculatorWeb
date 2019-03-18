package ru.wkn.repository.h2;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.wkn.entities.Operation;
import ru.wkn.repository.IDao;

import java.util.List;
import java.util.Objects;

public class H2OperationDao implements IDao<Operation, Integer> {

    private Session session;

    public H2OperationDao(Session session) {
        this.session = session;
    }

    @Override
    public void create(Operation newOperation) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(newOperation);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    @Override
    public Operation read(Integer index) {
        return (Operation) session.get(Operation.class, index);
    }

    @Override
    public void update(Operation transientOperation) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(transientOperation);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    @Override
    public void delete(Operation transientOperation) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(transientOperation);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    @Override
    public List<Operation> getAll() {
        List<Operation> vList;
        Query query = session.createQuery("SELECT * FROM operation");
        vList = (List<Operation>) query.list();
        return vList;
    }
}
