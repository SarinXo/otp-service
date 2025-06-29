package sarinxo.otpservice.controller;

import org.slf4j.MDC;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sarinxo.otpservice.dto.common.ResponseWrapper;
import sarinxo.otpservice.dto.exception.DefaultExceptionDto;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static sarinxo.otpservice.constant.RequestConstant.REQUEST_ID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseWrapper<DefaultExceptionDto> unexpectedException(Exception e) {
        String requestIdString = MDC.get(REQUEST_ID);
        UUID requestId = UUID.fromString(requestIdString);
        LocalDateTime timestamp = LocalDateTime.now();
        String exceptionMessage = e.getMessage();

        DefaultExceptionDto body = new DefaultExceptionDto(requestId, timestamp, exceptionMessage);

        return ResponseWrapper.of(body);
    }

}
