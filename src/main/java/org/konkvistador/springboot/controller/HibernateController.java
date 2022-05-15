package org.konkvistador.springboot.controller;

import org.konkvistador.springboot.entity.Person;
import org.konkvistador.springboot.service.HibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.security.RolesAllowed;
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
    @Secured("ROLE_READ")
    //возвращает значения только для пользователей с ролью "READ"(используйте @Secured)
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return hibernateService.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    @RolesAllowed("ROLE_WRITE")
    //возвращает значения только для пользователей с ролью "WRITE"(используйте @RolesAllowed)
    public List<Person> getPersonsByAgeLessThan(@RequestParam int age) {
        return hibernateService.getPersonsByAgeLessThan(age);
    }

    @GetMapping("/persons/by-fullName")
    @PostAuthorize("hasRole('WRITE') or hasRole('DELETE')")
    //возвращает значения, если у пользователя есть хотя бы одна из ролей из "WRITE","DELETE"
    // (используйте pre/post аннотации)
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return hibernateService.getPersonsByNameAndSurname(name, surname);
    }

    @GetMapping("/persons/by-firstName")
    @PreAuthorize("#username == authentication.principal.username")
    // принимает в качестве query параметра имя пользователя(username),
    // возвращает значения только если у пользователя username совпадает с именем пользователя
    // в вашем объекте Authentication, который Spring security
    // сохраняет в SecurityContextHolder после успешной аутентификации.
    public Optional<Person> getPersonsByName(@RequestParam String name) {
        return hibernateService.getPersonsByName(name);
    }
}
