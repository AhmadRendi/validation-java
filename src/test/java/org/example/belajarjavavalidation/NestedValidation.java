package org.example.belajarjavavalidation;

import org.example.belajarjavavalidation.model.Address;
import org.example.belajarjavavalidation.model.Person;
import org.example.belajarjavavalidation.validation.ValidationVactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NestedValidation {


    @Test
    void name() {
        ValidationVactory<Person> validationVactory = new ValidationVactory<>();
        Person person = new Person();

        Address address = new Address();

        person.setAddress(address);
        for (var value : validationVactory.validate(person)){
            System.out.println(value.getMessage());
            System.out.println(value.getPropertyPath());
            System.out.println("==============");
        }
     }
}
