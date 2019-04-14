package com.waldi.personviewing.service;

import com.waldi.personviewing.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> list();

    Person get(long id);

    long save(Person person);

    void update(long id, Person person);

    void delete(long id);
}
