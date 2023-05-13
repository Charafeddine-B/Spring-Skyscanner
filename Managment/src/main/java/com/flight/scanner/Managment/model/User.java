package com.flight.scanner.Managment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String lastname;


    private String username;

    private String email;


    private String password;


    @ManyToMany
    private List<Role> roles;

}
