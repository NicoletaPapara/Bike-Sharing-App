package com.app.bikesharing.exceptions;

import lombok.Getter;

public class InvalidDatesException extends Exception{

    @Getter
    private final int code;

    public InvalidDatesException(String message, int code){
        super(message);
        this.code=code;
    }
}
