package ru.netology.javaqa.javamvn.tournament;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String message) {

        super(message + " is not registered");
    }
}
