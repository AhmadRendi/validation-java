package org.example.belajarjavavalidation.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Customers {

    @Email (message = "email is not valid")
    @NotBlank (message = "email can't blank")
    private String email;

    @NotBlank (message = "name can't blank")
    private String name;

    public Customers(){

    }
    public Customers(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
