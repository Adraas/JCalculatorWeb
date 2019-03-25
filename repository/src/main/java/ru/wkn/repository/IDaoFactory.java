package ru.wkn.repository;

import org.hibernate.Session;

import java.io.Serializable;

public interface IDaoFactory<V, I extends Serializable> {

    IDao<V, I> createDao(Class<IDao<V, I>> daoClass, Class<V> entityClass, Session session);
}
