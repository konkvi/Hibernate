package org.konkvistador.springboot;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class HibernateRepository {

    @PersistenceContext
    public EntityManager entityManager;

    public List getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Person p where p.cityOfLiving = :cityOfLiving", Person.class);
        query.setParameter("cityOfLiving", city);
        return query.getResultList();
    }
}
