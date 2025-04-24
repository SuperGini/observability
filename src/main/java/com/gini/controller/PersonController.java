package com.gini.controller;

import com.gini.dto.request.PersonRequest;
import com.gini.dto.response.PersonResponse;
import com.gini.services.PersonService;
import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.context.Context;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public PersonResponse findById(@PathVariable String id, @RequestHeader(required = false, name = "user-tracking-key") String token) {
        log.info("findById: {}, traking-key {}", id, token);

        log.info("----> All Baggage: {}", Baggage.fromContext(Context.current())
                .asMap()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().getValue())));

       var mdc =  MDC.get("user-tracking-key");
        log.info("MDC value: {}", mdc);

        return personService.findById(id);
    }

    @GetMapping("/persons")
    List<PersonResponse> findAll() {
        log.info("findAll from database");
        return personService.getAllPersons();
    }

}
