package com.gini.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(id, person.id) && Objects.equals(username, person.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

}
