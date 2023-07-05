package com.yash.ytms.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This class will handle the exception
 * 
 * @author dheerendra.kag
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * This method will handle the resource not found exception
	 * 
	 * @param e user define TRFNotFound Exception
	 * @return the handler message
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(TRFNotFound.class)
	private ResponseEntity<Object> handleResourceNotFoundException(TRFNotFound e) {
		Map<String, String> map = new HashMap<>();
		map.put("error", e.getMessage());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(map);
	}

	/**
	 * This method will handle the bad request exception
	 * 
	 * @param ex predefine argument not valid exception
	 * @return the handler message
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> map = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(e -> {
			map.put(e.getField(), e.getDefaultMessage());
		});
		return map;
	}

	@ExceptionHandler(TrainerNotFound.class)
	private ResponseEntity<Object> resourceNotFoundException(TrainerNotFound ex) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("error", ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}

	@ExceptionHandler(TrainingSummaryNotFound.class)
	private ResponseEntity<Object> resourceNotFoundException(TrainingSummaryNotFound ex) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("error", ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	} 
	

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFound.class)
	private ResponseEntity<Object> handleUserNotFoundException(UserNotFound e) {
		Map<String, String> map = new HashMap<>();
		map.put("error", e.getMessage());
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserAlreadyExistsException.class)
	private ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistsException e) {
		Map<String, String> map = new HashMap<>();
		map.put("error", e.getMessage());
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}
}
