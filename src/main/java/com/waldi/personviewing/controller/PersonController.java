package com.waldi.personviewing.controller;

import com.waldi.personviewing.model.Person;
import com.waldi.personviewing.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin("*")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")

    public ResponseEntity<List<Person>> list() {
        return new ResponseEntity<>(personService.list(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable Long id) {
        return new ResponseEntity<>(personService.get(id), OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Person person) {
        personService.update(id, person);
        return ResponseEntity.ok().body("Person updated");
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        personService.save(person);
        return person;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.ok().body("Book has been deleted");
    }


}
