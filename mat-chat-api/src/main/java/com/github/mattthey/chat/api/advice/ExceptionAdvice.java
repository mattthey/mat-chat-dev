package com.github.mattthey.chat.api.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j(topic = "api.response")
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnknownException(
            final Exception exception
    ) {
        log.error("Server error: ", exception);

        // todo must be norm object
        return ResponseEntity.internalServerError()
                .body("Server error");
    }
}
