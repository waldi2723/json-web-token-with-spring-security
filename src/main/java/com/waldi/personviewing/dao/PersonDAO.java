package com.waldi.personviewing.dao;

import com.waldi.personviewing.model.Person;

import java.util.List;

public interface PersonDAO extends GenericDAO<Person> {

    List<Person> list();

    Person get(long id);

    long save(Person person);

    void update(long id, Person person);

    void delete(long id);
}
