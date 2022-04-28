package com.airlineapp.exceptions;

import com.airlineapp.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","method not allowed");
        String error=ex.getMessage();
        List<String> messages= Arrays.asList(error,"method not supported");
        ApiErrors apiErrors= new ApiErrors(LocalDateTime.now(),status, status.value(), error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","method type not supported");
        String error=ex.getMessage();
        List<String> messages= Arrays.asList(error,"invalid media type");
        ApiErrors apiErrors= new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","path variable is missing");
        String error=ex.getMessage();
        List<String> messages= Arrays.asList(error,"missing pathvariable");
        ApiErrors apiErrors= new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","req param is missing");
        String error=ex.getMessage();
        List<String> messages= Arrays.asList(error,"invalid request parameter");
        ApiErrors apiErrors= new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc", "invalid datatype");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error, "data type is invalid");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), status,status.value(), error, messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<Object> handleFurnNotFound(Exception ex){
       HttpHeaders headers= new HttpHeaders();
        headers.add("desc","furniture not found");
        String error=ex.getMessage();
        List<String> messages= Arrays.asList(error,"furniture not available");
        ApiErrors apiErrors= new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOther(Exception ex){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Other Exception");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Other type of exception");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),HttpStatus.NOT_ACCEPTABLE,HttpStatus.NOT_ACCEPTABLE.value(),error,messages);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(errors);
    }

}
