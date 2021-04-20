package com.springboot.api.resource.exceptions;

public class AddressNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public AddressNotFoundException(Object id) {
        super("Address not found with id: " + id);
    }
}
