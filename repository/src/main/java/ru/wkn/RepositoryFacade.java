package ru.wkn;

import org.hibernate.Session;
import ru.wkn.jpa.HibernateUtil;
import ru.wkn.repository.DaoFactory;
import ru.wkn.repository.IDao;
import ru.wkn.repository.IDaoFactory;
import ru.wkn.repository.IService;
import ru.wkn.repository.service.Service;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class RepositoryFacade<V, I extends Serializable> {

    private Class<IDao<V, I>> daoClass;
    private Class<V> entityClass;
    private final IDaoFactory<V, I> daoFactory = new DaoFactory<>();
    private IService<V, I> service;

    public RepositoryFacade(Class<IDao<V, I>> daoClass, Class<V> entityClass) {
        this.daoClass = daoClass;
        this.entityClass = entityClass;
        initService();
    }

    private void initService() {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        IDao<V, I> dao = daoFactory.createDao(daoClass, entityClass, (Session) entityManager.getDelegate());
        service = new Service<>(dao);
    }

    public void setDaoClass(Class<IDao<V, I>> daoClass) {
        this.daoClass = daoClass;
        initService();
    }

    public void setEntityClass(Class<V> entityClass) {
        this.entityClass = entityClass;
        initService();
    }

    public IService<V, I> getService() {
        return service;
    }
}
