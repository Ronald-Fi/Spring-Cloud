package com.example.rest.controller;

import com.example.rest.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRestController {
    /**
     * consumes:请求类型-对应请求头的"Content-Type"
     * produces:响应类型-对应请求头的"Accept"
     *
     * @param person
     * @return
     */
    @PostMapping(value = "/person/json/to/properties",
            //consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = "application/properties+person")
    public Person personJsonToProperties(@RequestBody Person person) {
        //读JSON、响应Properties
        return person;
    }

    @PostMapping(value = "/person/properties/to/json",
            consumes = "application/properties+person",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person personPropertiesToJson(@RequestBody Person person) {
        //读Properties、响应JSON
        return person;
    }
}
