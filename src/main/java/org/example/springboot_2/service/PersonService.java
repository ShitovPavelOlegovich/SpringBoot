package org.example.springboot_2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springboot_2.model.Person;
import org.example.springboot_2.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class PersonService implements CRUDService<Person> {

    private final PersonRepository personRepository;

    @Override
    public Collection<Person> getAllPerson() {
        log.info("Get all person");
        return personRepository.findAll();
    }

    @Override
    public Person getOnePerson(Integer id) {
        log.info("Get one person: " + id);
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(null);
    }

    @Override
    @Transactional
    public void create(Person person) {
        log.info("Create person");
        personRepository.save(person);
    }

    @Override
    @Transactional
    public void update(Integer id, Person updatePerson) {
        log.info("Update person: " + id);
        updatePerson.setId(id);
        personRepository.save(updatePerson);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        log.info("Delete person: " + id);
        personRepository.deleteById(id);
    }

}
