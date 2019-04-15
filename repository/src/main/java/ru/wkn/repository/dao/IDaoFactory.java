package ru.wkn.repository.dao;

import org.hibernate.Session;
import ru.wkn.entities.EntityType;

public interface IDaoFactory {

    IDao createDao(DaoType daoType, EntityType entityType, Session session);
}
