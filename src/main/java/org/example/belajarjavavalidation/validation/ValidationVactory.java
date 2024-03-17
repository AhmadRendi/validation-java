package org.example.belajarjavavalidation.validation;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class ValidationVactory<T>{

    private ValidatorFactory validatorFactory  = Validation.buildDefaultValidatorFactory();
    private Validator validator;



    public Set<ConstraintViolation<T>> validate (T object){
        try {
            validator = validatorFactory.getValidator();
            return validator.validate(object);
        }finally {
            validatorFactory.close();
        }
    }

    public Set<ConstraintViolation<T>> validaitonWithGrub(T o, Class<?>... classes){
        try {
            validator = validatorFactory.getValidator();
            return validator.validate(o, classes);
        }finally {
            validatorFactory.close();
        }
    }


}
