package com.nextlevelhomelab.labtracker.models.web;

import com.nextlevelhomelab.labtracker.models.utility.Result;
import com.nextlevelhomelab.labtracker.models.utility.ResultType;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor
public class ErrorResponse {

    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public static <T> ResponseEntity<Object> build(Result<T> result) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (result.getType() == null || result.getType() == ResultType.INVALID) {
            status = HttpStatus.BAD_REQUEST;
        } else if (result.getType() == ResultType.NOT_FOUND) {
            status = HttpStatus.NOT_FOUND;
        } else if (result.getType() == ResultType.FORBIDDEN) {
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<>(result.getMessages(), status);
    }
}
