package com.diamorph.datingapi.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserAccountNotFound extends RuntimeException {
    public UserAccountNotFound(String message) {
        super(message);
    }
}
