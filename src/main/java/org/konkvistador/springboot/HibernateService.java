package org.konkvistador.springboot;

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
        return personRepository.findByCityOfLiving(city);
    }

    public List<Person> getPersonsByAgeLessThan(int age) {
        return personRepository.findByPersonKeyAgeLessThan(age);
    }

    Optional<Person> getPersonsByNameAndSurname(String name, String surname) {
        return personRepository.findByPersonKeyNameAndPersonKeySurname(name, surname);
    }
}
