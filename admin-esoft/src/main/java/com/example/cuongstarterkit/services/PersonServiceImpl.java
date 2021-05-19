package com.example.cuongstarterkit.services;

import com.example.cuongstarterkit.db.jpa.entities.Person;
import com.example.cuongstarterkit.db.jpa.repositories.PersonRepository;
import com.example.cuongstarterkit.rest.response.AppErrorCode;
import com.example.cuongstarterkit.exceptions.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person create() {
        Person cuong = new Person();
//        cuong.setName("Cuong");

        // Exception interceptor
        if (true) {
            throw new AppException(AppErrorCode.PERSON_NOT_FOUND);
        }

        return personRepository.save(cuong);
    }
}
