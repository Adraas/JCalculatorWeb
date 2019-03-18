package ru.wkn.repository.h2;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.wkn.entities.User;
import ru.wkn.repository.IDao;

import java.util.List;
import java.util.Objects;

public class H2UserDao implements IDao<User, Integer> {

    private Session session;

    public H2UserDao(Session session) {
        this.session = session;
    }

    @Override
    public void create(User newUser) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(newUser);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    @Override
    public User read(Integer index) {
        return (User) session.get(User.class, index);
    }

    @Override
    public void update(User transientUser) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(transientUser);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    @Override
    public void delete(User transientUser) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(transientUser);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> vList;
        Query query = session.createQuery("SELECT * FROM user");
        vList = (List<User>) query.list();
        return vList;
    }
}
