package ru.wkn.repository;

import java.io.Serializable;
import java.util.List;

public interface IService<V, I extends Serializable> {

    boolean create(V newInstance);

    V read(I index);

    void update(V transientInstance);

    void delete(V transientInstance);

    List<V> getAll();

    IDao<V, I> getDao();
}
