package org.example.springboot_2.service;

import java.util.Collection;

public interface CRUDService<T>{
    Collection<T> getAllPerson();
    T getOnePerson(Integer id);
    void create(T person);
    void update(Integer id, T updatePerson);
    void delete(Integer id);
}
