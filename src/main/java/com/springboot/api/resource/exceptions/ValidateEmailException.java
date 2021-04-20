package com.springboot.api.resource.exceptions;

public class ValidateEmailException extends RuntimeException{

        public ValidateEmailException(String email) {

            super("Email: " + email + " already registered in the database!");
        }
    }
