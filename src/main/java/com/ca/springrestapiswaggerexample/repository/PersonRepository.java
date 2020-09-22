package com.ca.springrestapiswaggerexample.repository;

import com.ca.springrestapiswaggerexample.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
