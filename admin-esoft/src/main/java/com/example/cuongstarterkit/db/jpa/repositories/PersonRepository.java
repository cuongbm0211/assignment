package com.example.cuongstarterkit.db.jpa.repositories;


import com.example.cuongstarterkit.db.jpa.entities.Person;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, UUID> {

    List<Person> findPersonByFistName(String firstName);

    // find all with pagination


    // findOne, exists, findAll, count, delete, deleteAll

}
