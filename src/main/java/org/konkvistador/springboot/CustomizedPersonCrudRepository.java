package org.konkvistador.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomizedPersonCrudRepository extends JpaRepository<Person, PersonKey> {

    @Query("select p from Person p where p.cityOfLiving = :city")
    List<Person> findByCity(String city);

    @Query("select p from Person p where p.personKey.age<:age")
    List<Person> findByAge(int age);

    @Query("select p from Person p where p.personKey.name=:name and p.personKey.surname=:surname")
    Optional<Person> findByName(String name, String surname);

    //1 - метод, который принимает название города(city) и возвращает Entity из базы данных,
    // которые соответствуют этому city.
    //2 - метод, который принимает возраст(age) и возвращает Entity из базы данных,
    // которые меньше переданного age и отсортированы по возрастанию.
    //3 - метод, который принимает имя и фамилию(name и surname) и возвращает Entity из базы данных,
    // которые соответствуют сочетанию name и surname и является Optional.
}
