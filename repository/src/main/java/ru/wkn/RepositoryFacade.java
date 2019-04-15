package ru.wkn;

import org.hibernate.Session;
import ru.wkn.entities.EntityType;
import ru.wkn.jpa.HibernateUtil;
import ru.wkn.repository.dao.DaoFactory;
import ru.wkn.repository.dao.DaoType;
import ru.wkn.repository.dao.IDao;
import ru.wkn.repository.dao.IDaoFactory;
import ru.wkn.repository.service.IService;
import ru.wkn.repository.service.IServiceFactory;
import ru.wkn.repository.service.ServiceFactory;

import javax.persistence.EntityManager;

public class RepositoryFacade {

    private DaoType daoType;
    private EntityType entityType;
    private final IDaoFactory daoFactory = new DaoFactory();
    private final IServiceFactory serviceFactory = new ServiceFactory();
    private IService service;

    public RepositoryFacade(DaoType daoType, EntityType entityType) {
        this.daoType = daoType;
        this.entityType = entityType;
        initService();
    }

    private void initService() {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        IDao dao = daoFactory.createDao(daoType, entityType, (Session) entityManager.getDelegate());
        service = serviceFactory.createService(dao);
    }

    public void setDaoType(DaoType daoType) {
        this.daoType = daoType;
        initService();
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
        initService();
    }

    public IService getService() {
        return service;
    }
}
