package com.example.cuongstarterkit.db.jpa.entities;

import com.example.cuongstarterkit.db.jpa.entities.common.BaseEntity;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity(name = "persons")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Person extends BaseEntity {

    String fistName;
    String lastName;
    Integer age;
}
