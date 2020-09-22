package com.ca.springrestapiswaggerexample.service;

import com.ca.springrestapiswaggerexample.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();

    Person save(Person personBody);

    void update(Person person, Integer id);

    void delete(Integer id);

    Person getFindById(Integer id);

}
