package ru.wkn.repository.dao.h2;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.wkn.repository.GeneralDao;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class H2Dao<V, I> implements GeneralDao {

    private Class<V> vClass;
    private Session session;

    public H2Dao(Class<V> vClass, Session session) {
        this.vClass = vClass;
        this.session = session;
    }

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

    public V read(I index) {
        return (V) session.get(vClass, (Serializable) index);
    }

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

    public List<V> getAll(String table) {
        List<V> vList;
        Query query = session.createQuery("SELECT * FROM ".concat(table));
        vList = (List<V>) query.list();
        return vList;
    }
}
