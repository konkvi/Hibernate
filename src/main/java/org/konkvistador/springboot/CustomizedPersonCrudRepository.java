package org.konkvistador.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomizedPersonCrudRepository extends JpaRepository<Person, PersonKey> {

    List<Person> findByCityOfLiving(String city);

    List<Person> findByPersonKeyAgeLessThan(int age);

    Optional<Person> findByPersonKeyNameAndPersonKeySurname(String name, String surname);

    //1 - метод, который принимает название города(city) и возвращает Entity из базы данных,
    // которые соответствуют этому city.
    //2 - метод, который принимает возраст(age) и возвращает Entity из базы данных,
    // которые меньше переданного age и отсортированы по возрастанию.
    //3 - метод, который принимает имя и фамилию(name и surname) и возвращает Entity из базы данных,
    // которые соответствуют сочетанию name и surname и является Optional.
}
