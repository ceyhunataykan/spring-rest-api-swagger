package com.ca.springrestapiswaggerexample.conroller;

import com.ca.springrestapiswaggerexample.entity.Person;
import com.ca.springrestapiswaggerexample.exception.GenericNotFoundException;
import com.ca.springrestapiswaggerexample.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(value = "Person Api Documentation")
public class PersonController {
    @Autowired
    private PersonService personService;

    @ApiOperation(value = "Person List Metod")
    @GetMapping("/list")
    public ResponseEntity<List<Person>> getAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Person Find Id Metod")
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Person> getFindById(@PathVariable Integer id) {
        return new ResponseEntity<>(personService.getFindById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Person Add Metod")
    @PostMapping("/add")
    public ResponseEntity<Person> add(@RequestBody Person person) {
        return new ResponseEntity<>(personService.save(person), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Person Update Metod")
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@RequestBody Person person, @PathVariable Integer id) {
        personService.update(person, id);
        return new ResponseEntity<>("true", HttpStatus.OK);
    }

    @ApiOperation(value = "Person Delete Metod")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) throws GenericNotFoundException {
        personService.delete(id);
        return new ResponseEntity<>("true", HttpStatus.OK);
    }
}
