package com.app.bikesharing.exceptions;

import lombok.Getter;

public class NoBikesFoundException extends Exception {

    @Getter
    private final int code;

    public NoBikesFoundException(String message, int code) {
        super(message);
        this.code = code;
    }
}
