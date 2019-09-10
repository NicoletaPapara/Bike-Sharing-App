package com.app.bikesharing.exceptions;

import lombok.Getter;

public class NoAvailableBikesException extends Exception {
    @Getter
    private final int code;

    public NoAvailableBikesException(String message, int code) {
        super(message);
        this.code = code;
    }
}
