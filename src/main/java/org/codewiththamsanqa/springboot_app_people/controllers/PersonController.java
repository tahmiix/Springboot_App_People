package org.codewiththamsanqa.springboot_app_people.controllers;

import org.codewiththamsanqa.springboot_app_people.dto.PersonRequest;
import org.codewiththamsanqa.springboot_app_people.dto.PersonResponse;
import org.codewiththamsanqa.springboot_app_people.entity.Person;
import org.codewiththamsanqa.springboot_app_people.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest request){
        PersonResponse response = personService.createPerson(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getPerson(@PathVariable Long id){
        PersonResponse response = personService.getPerson(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }
}
