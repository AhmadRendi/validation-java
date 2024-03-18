package org.example.belajarjavavalidation.validation;


import jakarta.validation.*;

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


    public void validationWithException(Object o){
        validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }

    public void validationWithExceptionWithGrub(Object o, Class<?>... classes){
        validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(o, classes);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }


}
