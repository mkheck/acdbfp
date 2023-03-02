package com.thehecklers.acdbfp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String firstName, lastName, address;
}
