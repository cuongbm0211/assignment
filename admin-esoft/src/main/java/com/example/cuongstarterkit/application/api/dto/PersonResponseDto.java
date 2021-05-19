package com.example.cuongstarterkit.application.api.dto;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonResponseDto {

    UUID id;
    String firstName;
    String lastName;
    Integer age;
}
