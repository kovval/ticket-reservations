package com.github.java4wro.user.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by admin on 10.11.2017.
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private UserRole rola;

}
