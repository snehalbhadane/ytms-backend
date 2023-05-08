package com.yash.ytms.exception;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(TRFNotFound.class)
  private ResponseEntity<Object> handleResourceNotFoundException(TRFNotFound e) {
	    Map<String, String> map = new HashMap<>();
	    map.put("error", e.getMessage());
        return ResponseEntity
          .status(HttpStatus.FORBIDDEN)
          .body(map);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
	  Map<String, String> map = new HashMap<>();
	  ex.getBindingResult().getFieldErrors().forEach(e->{
		  map.put(e.getField(), e.getDefaultMessage());
	  });
	  return map;
  }
}
