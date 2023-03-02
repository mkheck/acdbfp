package com.thehecklers.acdbfp;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataLoader {
    private final PersonRepository repo;

    @PostConstruct
    public void loadData() {
        repo.deleteAll();

        repo.saveAll(List.of(new Person("Alpha", "Bravo", "123 N 4567th St"),
                new Person("Charlie", "Delta", "1313 Mockingbird Lane")));

        repo.findAll().forEach(System.out::println);
    }
}
