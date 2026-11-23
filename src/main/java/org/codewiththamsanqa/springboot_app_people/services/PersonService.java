package org.codewiththamsanqa.springboot_app_people.services;

import org.codewiththamsanqa.springboot_app_people.dto.PersonRequest;
import org.codewiththamsanqa.springboot_app_people.dto.PersonResponse;
import org.codewiththamsanqa.springboot_app_people.entity.Person;
import org.codewiththamsanqa.springboot_app_people.exceptions.ResponseException;
import org.codewiththamsanqa.springboot_app_people.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@Service
public class PersonService {
    
    final PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    
    @PostMapping
    public PersonResponse createPerson(PersonRequest request){
        Person person = new Person();

        person.setName(request.name());
        person.setEmail(request.email());

        Person savedPerson = personRepository.save(person);

        return fromEntity(savedPerson);
    }


    public PersonResponse getPerson(Long id){
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResponseException("Not Found"));

        return new PersonResponse(person.getName(),person.getEmail());
    }


    private PersonResponse fromEntity(Person person){
        return new PersonResponse(
                person.getEmail(),
                person.getName()
        );
    }
    
}
