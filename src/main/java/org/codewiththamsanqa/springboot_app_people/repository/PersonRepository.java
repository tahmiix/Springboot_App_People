package org.codewiththamsanqa.springboot_app_people.repository;

import org.codewiththamsanqa.springboot_app_people.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String email);
}
