package com.github.java4wro.generator.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerPdfDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;


}
