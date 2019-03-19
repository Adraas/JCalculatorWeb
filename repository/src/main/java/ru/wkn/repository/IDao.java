package ru.wkn.repository;

import java.util.List;

public interface IDao<V, I> {

    void create(V newInstance);

    V read(I index);

    void update(V transientInstance);

    void delete(V transientInstance);

    List<V> getAll(String table);
}