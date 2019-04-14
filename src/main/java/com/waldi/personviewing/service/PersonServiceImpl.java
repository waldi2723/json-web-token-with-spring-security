package com.waldi.personviewing.service;

import com.waldi.personviewing.dao.GenericDAO;
import com.waldi.personviewing.dao.PersonDAO;
import com.waldi.personviewing.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private GenericDAO<Person> personDAO;

    @Override
    public List<Person> list() {
        return personDAO.list();
    }

    @Override
    public Person get(long id) {
        return personDAO.get(id);
    }

    @Override
    public long save(Person person) {
        return personDAO.save(person);
    }

    @Override
    public void update(long id, Person person) {
        personDAO.update(id, person);
    }

    @Override
    public void delete(long id) {
        personDAO.delete(id);
    }
}
