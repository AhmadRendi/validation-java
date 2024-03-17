package org.example.belajarjavavalidation.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import org.springframework.aop.framework.adapter.AdvisorAdapterRegistrationManager;

public class Person {

    @NotBlank (message = "last name can't blank")
    private String lastName;


    @NotBlank (message = "first name can't blank")
    @Size(max = 20,message = "max first name is 20")
    @Size (min = 5, message = "min first name is 5")
    private String firstName;


    @NotNull (message = "address can't null")
    /*
        * jika kita ingin menvalidasi nested class maka kita perlu menambahkan annotation valid
        * agar semua field yang didalam class address ikut tervalidasi
     */
    @Valid
    private Address address;

    public Person() {
    }

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
