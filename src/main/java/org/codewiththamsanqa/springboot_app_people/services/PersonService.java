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

import java.util.List;


@Service
public class PersonService {
    
    final PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    
    @PostMapping
    public PersonResponse createPerson(PersonRequest request){
        Person person = new Person();

        person.setEmail(request.email());
        person.setName(request.name());


        Person savedPerson = personRepository.save(person);

        return fromEntity(savedPerson);
    }


    public PersonResponse getPerson(Long id){
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResponseException("Not Found"));

        return new PersonResponse(person.getName(),person.getEmail());
    }

    public List<Person> getAll(){

        List<Person> users = personRepository.findAll();

        return users;

    }

    @PutMapping
    public PersonResponse updatePerson(Long id, PersonRequest request){
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResponseException("NOT FOUND"));

        person.setEmail(request.email());
        person.setName(request.name());

        Person savedPerson = personRepository.save(person);
        return fromEntity(savedPerson);

    }

    public String deletePerson(Long id){
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResponseException("NOT FOUND"));

        personRepository.delete(person);

        return "Removed";

    }

    private PersonResponse fromEntity(Person person){
        return new PersonResponse(
                person.getName(),
                person.getEmail()

        );
    }


    
}
