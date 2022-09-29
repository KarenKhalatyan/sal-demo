package com.emp.sal.demo.saldemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="invalid month")
public class InvalidMonthException extends RuntimeException{
    private static final long serialVersionUID = -4442292346834265371L;

    public InvalidMonthException(String message) {
        super(message);
    }
}
