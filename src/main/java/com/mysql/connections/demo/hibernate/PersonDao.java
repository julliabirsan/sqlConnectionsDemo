package com.mysql.connections.demo.hibernate;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void save(String nume, String prenume){
        Person p = new Person();
        p.setNume(nume);
        p.setPrenume(prenume);
        entityManager.persist(p);
    }

    public List<Person> selectPerson(){
        Query query = entityManager.createNativeQuery("select * from person", Person.class);
        return query.getResultList();
    }
}
