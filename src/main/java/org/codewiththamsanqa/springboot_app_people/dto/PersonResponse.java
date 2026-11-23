package org.codewiththamsanqa.springboot_app_people.dto;

import org.codewiththamsanqa.springboot_app_people.entity.Person;

public record PersonResponse(
        String name,
        String email
) {

    public PersonResponse fromEntity(Person person){

        return new PersonResponse(person.getName(), person.getEmail());
    }
}
