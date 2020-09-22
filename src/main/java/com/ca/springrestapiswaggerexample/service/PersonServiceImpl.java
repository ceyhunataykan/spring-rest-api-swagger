package com.ca.springrestapiswaggerexample.service;

import com.ca.springrestapiswaggerexample.entity.Person;
import com.ca.springrestapiswaggerexample.exception.GenericNotFoundException;
import com.ca.springrestapiswaggerexample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person save(Person personBody) {
        return personRepository.save(personBody);
    }

    @Override
    public void update(Person person, Integer id) {
        Person optionalPerson = getFindById(id);
        if (!(optionalPerson == null)) {
            person.setId(id);
            personRepository.save(person);
        } else {
            throw new GenericNotFoundException();
        }
    }

    @Override
    public void delete(Integer id) {
        Person optionalPerson = getFindById(id);
        if (optionalPerson != null) {
            personRepository.deleteById(id);
        } else {
            throw new GenericNotFoundException();
        }
    }

    @Override
    public Person getFindById(Integer id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (!optionalPerson.isPresent()) {
            throw new GenericNotFoundException();
        }
        return optionalPerson.get();
    }
}
