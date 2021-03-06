package ru.wkn.repository.dao.h2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.wkn.repository.dao.IDao;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class H2Dao<V, I extends Serializable> implements IDao<V, I> {

    private Class<V> entityClass;
    private Session session;
    private static final Logger logger = Logger.getLogger(H2Dao.class.getName());

    public H2Dao(Class<V> entityClass, Session session) {
        this.entityClass = entityClass;
        this.session = session;
    }

    @Override
    public boolean create(V newInstance) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(newInstance);
            transaction.commit();
        } catch (HibernateException e) {
            logger.warning("Element ".concat(newInstance.toString()).concat(" not created"));
            Objects.requireNonNull(transaction).rollback();
            return false;
        }
        return true;
    }

    @Override
    public V read(I index) {
        return session.get(entityClass, index);
    }

    @Override
    public void update(V transientInstance) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(transientInstance);
            transaction.commit();
        } catch (HibernateException e) {
            logger.warning("Element ".concat(transientInstance.toString()).concat(" not updated"));
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
            logger.warning("Element ".concat(transientInstance.toString()).concat(" not deleted"));
            Objects.requireNonNull(transaction).rollback();
        }
    }

    @Override
    public List<V> getAll() {
        List<V> vList;
        Query query = session.createQuery("SELECT * FROM ".concat(getTableName()));
        vList = (List<V>) query.list();
        return vList;
    }

    private String getTableName() {
        Table tableAnnotation = entityClass.getAnnotation(Table.class);
        return tableAnnotation.name();
    }

    @Override
    public void finalize() {
        if (session.isOpen()) {
            session.close();
        }
    }

    public Class<V> getEntityClass() {
        return entityClass;
    }

    public Session getSession() {
        return session;
    }
}
