package org.konkvistador.springboot.service;

import org.konkvistador.springboot.entity.Person;
import org.konkvistador.springboot.repository.CustomizedPersonCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HibernateService {
    private final CustomizedPersonCrudRepository personRepository;

    @Autowired
    public HibernateService(CustomizedPersonCrudRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonsByCity(String city) {
        return personRepository.findByCity(city);
    }

    public List<Person> getPersonsByAgeLessThan(int age) {
        return personRepository.findByAge(age);
    }

    public Optional<Person> getPersonsByNameAndSurname(String name, String surname) {
        return personRepository.findByFullName(name, surname);
    }

    public Optional<Person> getPersonsByName(String name) {
        return personRepository.findByFirstName(name);
    }
}
