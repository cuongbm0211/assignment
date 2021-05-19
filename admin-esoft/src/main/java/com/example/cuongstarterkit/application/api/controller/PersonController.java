package com.example.cuongstarterkit.application.api.controller;

import com.example.cuongstarterkit.application.api.dto.PersonRequestDto;
import com.example.cuongstarterkit.application.api.dto.PersonResponseDto;
import com.example.cuongstarterkit.rest.response.BaseResponse;
import com.example.cuongstarterkit.services.PersonService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/persons")
@RequiredArgsConstructor
@Slf4j
public class PersonController {

    private final PersonService personService;

    // todo BaseResponse<Person>
    @PostMapping
    public ResponseEntity<BaseResponse<PersonResponseDto>> addNewPerson() {
//        Person cuong = new Person();
//        cuong.setName("Cuong");
//        Person saved = personRepository.save(cuong);
//        Person saved = personService.create();

        PersonResponseDto cuong = new PersonResponseDto();
        cuong.setFirstName("bui");
        cuong.setLastName("cuong");

        return ResponseEntity.ok(BaseResponse.ofSucceeded(cuong));

    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<PersonResponseDto>> updatePerson(
        @PathVariable(name = "id") UUID id,
        @RequestBody PersonRequestDto request) {
//        Person cuong = new Person();
//        cuong.setName("Cuong");
//        Person saved = personRepository.save(cuong);
//        Person saved = personService.create();


        PersonResponseDto cuong = new PersonResponseDto();
        cuong.setFirstName("bui");
        cuong.setLastName("cuong");

        return ResponseEntity.ok(BaseResponse.ofSucceeded(cuong));

    }
}
