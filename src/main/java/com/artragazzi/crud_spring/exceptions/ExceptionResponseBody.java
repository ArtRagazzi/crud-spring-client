package com.artragazzi.crud_spring.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExceptionResponseBody {

    private HttpStatus status;
    private String message;
    private String date;

    public ExceptionResponseBody(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.date = formatDate(LocalDateTime.now());
    }

    public String formatDate(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTime.format(formatter);

    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
