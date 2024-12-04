package com.naveen.learningnavigator.controller;

import com.naveen.learningnavigator.service.NumberFactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fact")
public class NumberFactsController {

    @Autowired
    private NumberFactsService service;

    @GetMapping("/{number}")
    public ResponseEntity<String> getFacts(@PathVariable(name = "number") int number){

        return ResponseEntity.ok(service.getFact(number));

    }

}
