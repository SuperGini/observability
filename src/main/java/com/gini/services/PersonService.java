package com.gini.services;

import com.gini.dto.request.PersonRequest;
import com.gini.dto.response.PersonResponse;
import com.gini.entities.Person;
import com.gini.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
