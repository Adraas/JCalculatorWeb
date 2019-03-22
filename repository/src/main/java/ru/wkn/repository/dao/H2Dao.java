package ru.wkn.repository.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.wkn.repository.IDao;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class H2Dao<V, I> implements IDao<V, I> {

    private Class<V> entityClass;
    private Session session;

    public H2Dao(Class<V> entityClass, Session session) {
        this.entityClass = entityClass;
        this.session = session;
    }

    @Override
    public void create(V newInstance) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(newInstance);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    @Override
    public V read(I index) {
        return session.get(entityClass, (Serializable) index);
    }

    @Override
    public void update(V transientInstance) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(transientInstance);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    @Override
    public void delete(V transientInstance) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(transientInstance);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    @Override
    public List<V> getAll(String table) {
        List<V> vList;
        Query query = session.createQuery("SELECT * FROM ".concat(table));
        vList = (List<V>) query.list();
        return vList;
    }
}
