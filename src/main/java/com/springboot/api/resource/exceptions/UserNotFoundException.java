package com.springboot.api.resource.exceptions;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public UserNotFoundException(Object id) {
        super("User not found with id: " + id);
    }
}
