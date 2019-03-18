package ru.wkn.repository;

import org.hibernate.Session;

public interface IDaoFactory<V, I> {

    IDao<V, I> createDao(String database, Class<V> entityClass, Session session);
}
