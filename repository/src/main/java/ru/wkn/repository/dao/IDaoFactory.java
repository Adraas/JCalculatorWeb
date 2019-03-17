package ru.wkn.repository.dao;

public interface IDaoFactory<V, I> {

    IDao<V, I> createDao(Class<V> vClass);
}
