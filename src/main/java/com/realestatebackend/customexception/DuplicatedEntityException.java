package com.realestatebackend.customexception;

/**
 * Custom exception for duplicated entity
 */
public class DuplicatedEntityException extends SQLCustomException{

    public DuplicatedEntityException(String message) {
        super(message);
    }
}
