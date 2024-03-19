package ru.gb.springbootlesson3.controllers;

import lombok.Getter;

@Getter
public class BookRequest {
    private final String name;

    public BookRequest(String name) {
        this.name = name;
    }

}
