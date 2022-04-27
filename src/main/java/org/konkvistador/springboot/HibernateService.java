package org.konkvistador.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateService {
    private final HibernateRepository hibernateRepository;

    @Autowired
    public HibernateService(HibernateRepository hibernateRepository) {
        this.hibernateRepository = hibernateRepository;
    }

    public List<Person> getPersonsByCity(String city) {
        return hibernateRepository.getPersonsByCity(city);
    }
}
