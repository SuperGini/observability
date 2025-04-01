package com.gini.services;

import com.gini.dto.request.PersonRequest;
import com.gini.dto.response.PersonResponse;
import com.gini.entities.Person;
import com.gini.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public PersonResponse save(PersonRequest personRequest) {

        var personDB = Person.builder()
                .username(personRequest.username())
                .firstName(personRequest.firstName())
                .lastName(personRequest.lastName())
                .build();

        personRepository.save(personDB);

        return new PersonResponse(
                personDB.getId(),
                personDB.getUsername(),
                personDB.getFirstName(),
                personDB.getLastName()
        );
    }

    @Transactional(readOnly = true)
    public PersonResponse findById(String id) {
        return personRepository.findById(id)
                .map(x -> new PersonResponse(x.getId(), x.getUsername(), x.getFirstName(), x.getLastName()))
                .orElseThrow(() -> new RuntimeException("person not found"));
    }

    @Transactional(readOnly = true)
    public List<PersonResponse> getAllPersons() {
        return personRepository.findAll().stream()
                .map(person -> new PersonResponse(
                        person.getId(),
                        person.getUsername(),
                        person.getFirstName(),
                        person.getLastName())
                )
                .toList();
    }

}
