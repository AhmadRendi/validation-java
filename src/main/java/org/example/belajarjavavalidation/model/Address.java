package org.example.belajarjavavalidation.model;

import jakarta.validation.constraints.NotBlank;

public class Address {

    @NotBlank (message = "street can't blank")
    private String street;

    @NotBlank (message = "city can't blank")
    private String city;

    @NotBlank (message = "country can't blank")
    private String country;

    public Address() {
    }

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
