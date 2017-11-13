package com.github.java4wro.user.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;
    @NotNull @NotBlank
    private String password;

    private UserRole role;

    private boolean enabled;

}
