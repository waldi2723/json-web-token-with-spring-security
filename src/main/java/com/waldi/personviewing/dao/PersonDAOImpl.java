package com.waldi.personviewing.dao;

import com.waldi.personviewing.model.Person;
import com.waldi.personviewing.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Cacheable("persons")
    public List<Person> list() {
        return personRepository.findAll();
    }

    @Override
    public Person get(long id) {
        return personRepository.getOne(id);
    }

    @Override
    public long save(Person person) {
        return personRepository.save(person).getId();
    }

    @Override
    public void update(long id, Person person) {
        person.setId(id);
        personRepository.save(person);
    }

    @Override
    public void delete(long id) {
        personRepository.deleteById(id);
    }
}
