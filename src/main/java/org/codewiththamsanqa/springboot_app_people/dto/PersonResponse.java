package org.codewiththamsanqa.springboot_app_people.dto;

import org.codewiththamsanqa.springboot_app_people.entity.Person;

public record PersonResponse(
        String name,
        String email
) {

}
