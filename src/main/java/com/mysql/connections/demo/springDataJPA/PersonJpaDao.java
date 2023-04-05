package com.mysql.connections.demo.springDataJPA;

import com.mysql.connections.demo.hibernate.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface PersonJpaDao extends CrudRepository<Person, Integer> {
   List<Person> findAllByNume(String nume);
}
