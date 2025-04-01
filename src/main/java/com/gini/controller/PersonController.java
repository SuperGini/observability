package com.gini.controller;

import com.gini.dto.request.PersonRequest;
import com.gini.dto.response.PersonResponse;
import com.gini.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/person")
    public PersonResponse save(@RequestBody PersonRequest personRequest) {
       return personService.save(personRequest);

    }




}
