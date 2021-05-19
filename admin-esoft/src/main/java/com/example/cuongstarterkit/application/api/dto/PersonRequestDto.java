package com.example.cuongstarterkit.application.api.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonRequestDto {

    String firstName;
    String lastName;
    Integer age;
}
