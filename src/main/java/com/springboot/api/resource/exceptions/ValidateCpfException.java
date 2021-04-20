package com.springboot.api.resource.exceptions;

public class ValidateCpfException extends RuntimeException {
    public ValidateCpfException(String cpf) {
        super("CPF: " + cpf + " already registered in the database!");
    }

}
