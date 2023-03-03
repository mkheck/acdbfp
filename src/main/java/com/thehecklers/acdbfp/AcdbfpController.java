package com.thehecklers.acdbfp;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class AcdbfpController {
    private final PersonRepository repo;

    @GetMapping
    Iterable<Person> getAllPersons() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    Optional<Person> getPersonById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @GetMapping("/oneperson")
    Person getFirstPerson() {
        return repo.findAll().iterator().next();
    }

    @PostMapping("/newperson")
    Person addPerson(@RequestBody Person Person) {
        return repo.save(Person);
    }
}
