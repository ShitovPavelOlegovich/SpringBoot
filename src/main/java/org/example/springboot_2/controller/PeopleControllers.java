package org.example.springboot_2.controller;

import org.example.springboot_2.model.Person;
import org.example.springboot_2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/people")
public class PeopleControllers {

    private final PersonService personService;

    @Autowired
    public PeopleControllers(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public Collection<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/{id}")
    public Person getOnePerson(@PathVariable int id) {
        return personService.getOnePerson(id);
    }

    @PostMapping()
    public void save(@RequestBody Person person) {
        personService.create(person);
    }

    @PatchMapping("/{id}")
    public void update(@RequestBody Person updatePerson, @PathVariable int id) {
        personService.update(id, updatePerson);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        personService.delete(id);
    }
}
