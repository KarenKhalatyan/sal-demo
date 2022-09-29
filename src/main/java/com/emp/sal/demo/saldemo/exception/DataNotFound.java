package com.emp.sal.demo.saldemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee Not Found") //404
public class DataNotFound extends RuntimeException {
    private static final long serialVersionUID = -3332292346834265371L;

    public DataNotFound(String message) {
        super(message);
    }
}