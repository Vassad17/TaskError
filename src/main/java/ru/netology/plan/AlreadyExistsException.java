package ru.netology.plan;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String s) {
        super(s);
    }
}

