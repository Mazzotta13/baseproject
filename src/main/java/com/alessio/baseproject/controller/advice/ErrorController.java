package com.alessio.baseproject.controller.advice;

import com.alessio.baseproject.model.ErrorEntity;
import com.alessio.baseproject.model.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.alessio.baseproject.controller"})
public class ErrorController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);

    // generic exception
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorEntity> handle(Exception e) {
        LOGGER.error("Exception was thrown", e);

        return ResponseEntity.ok(new ErrorEntity()
                .setApplicationErrorCode(ErrorInfo.GENERIC.getErrorCode())
                .setMessage(ErrorInfo.GENERIC.getMessage()));
    }

}