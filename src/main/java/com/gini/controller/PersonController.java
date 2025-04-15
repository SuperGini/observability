package com.gini.controller;

import com.gini.dto.request.PersonRequest;
import com.gini.dto.response.PersonResponse;
import com.gini.services.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/person")
    public PersonResponse save(@RequestBody PersonRequest personRequest) {
       return personService.save(personRequest);
    }

    @GetMapping("/person/{id}")
    public PersonResponse findById(@PathVariable String id) {
        log.info("findById: " + id);

        return personService.findById(id);
    }

    @GetMapping("/persons")
    List<PersonResponse> findAll() {
        log.info("findAll from database");
        return personService.getAllPersons();
    }

}
