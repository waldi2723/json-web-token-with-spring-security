package com.waldi.personviewing.dao;

import java.util.List;

public interface GenericDAO<T> {

    List<T> list();

    T get(long id);

    long save(T person);

    void update(long id, T person);

    void delete(long id);
}
