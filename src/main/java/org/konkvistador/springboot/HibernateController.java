package org.konkvistador.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HibernateController {

    private final HibernateService hibernateService;

    @Autowired
    public HibernateController(HibernateService hibernateService) {
        this.hibernateService = hibernateService;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return hibernateService.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAgeLessThan(@RequestParam int age) {
        return hibernateService.getPersonsByAgeLessThan(age);
    }

    @GetMapping("/persons/by-name")
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return hibernateService.getPersonsByNameAndSurname(name, surname);
    }
}
