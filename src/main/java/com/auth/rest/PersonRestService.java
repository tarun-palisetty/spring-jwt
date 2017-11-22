package com.auth.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PersonRestService {

    private static final List<Person> persons;

    static {
        persons = new ArrayList<>();
        persons.add(new Person("Hello", "World"));
        persons.add(new Person("Foo", "Bar"));
    }


    @RequestMapping(path = "/persons", method = RequestMethod.GET)
    public static List<Person> getPersons() {
        return persons;
    }

    @RequestMapping(path = "/person/{name}", method = RequestMethod.GET)
    public static Person getPerson(@PathVariable("name") String name) {
        return persons
                .stream()
                .filter(p -> p.getName().equals(name)).findAny().orElse(null);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }
}
