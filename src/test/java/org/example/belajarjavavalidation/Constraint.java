package org.example.belajarjavavalidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.belajarjavavalidation.model.Person;
import org.example.belajarjavavalidation.validation.ValidationVactory;
import org.junit.jupiter.api.*;

import java.util.Set;

public class Constraint {

    private ValidationVactory<Person> validationVactory = new ValidationVactory();
//
//    private ValidatorFactory validatorFactory;
//
//    private Validator validator;
//
//    @BeforeEach
//    void beforeAll() {
//       validatorFactory = Validation.buildDefaultValidatorFactory();
//       validator = validatorFactory.getValidator();
//    }
//
//
//    @AfterEach
//    void afterEach(){
//        validatorFactory.close();
//    }
//
    @Test
    void testConstraint() {
        Person person = new Person();
        person.setFirstName("Ahma");

        Set<ConstraintViolation<Person>> va = validationVactory.validate(person);

        for(var value : va){
            System.out.println("message error : " + value.getMessage());
        }

    }

//    private ValidatorFactory validatorFactory;
//
//    private Validator validator;
//
//    @BeforeEach
//    void setUp() {
//        validatorFactory = Validation.buildDefaultValidatorFactory();
//        validator = validatorFactory.getValidator();
//    }
//
//    @AfterEach
//    void tearDown() {
//        validatorFactory.close();
//    }
//
//    @Test
//    void testValidationFailedNotBlank() {
//
//        Person person = new Person();
//
//        Set<ConstraintViolation<Person>> violations = validator.validate(person);
//        Assertions.assertEquals(2, violations.size());
//
//        for (ConstraintViolation<Person> violation : violations) {
//            System.out.println("Message : " + violation.getMessage());
//            System.out.println("Bean : " + violation.getLeafBean());
//            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
//            System.out.println("Invalid Value : " + violation.getInvalidValue());
//            System.out.println("Path : " + violation.getPropertyPath());
//        }
//
//    }
}
