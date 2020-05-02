package com.library.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value  = { BooksException.class})
    protected ResponseEntity<ApiError> handleBooksConflict(RuntimeException ex, WebRequest request) {
		System.out.println("In Books Exception");
		
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "SOME_PROBLEM_OCCURED_PROCESSING_BOOKS", ex);
       // return apiError;
		
        // return handleExceptionInternal(ex, apiError, new HttpHeaders(), HttpStatus.CONFLICT, request);
        
        return new ResponseEntity<ApiError>(apiError, apiError.getStatus());
    }
	
	
	@ExceptionHandler(value  = { LibraryException.class})
    protected ResponseEntity<ApiError> handlelibraryConflict(RuntimeException ex, WebRequest request) {
		System.out.println("In Lib Exception");
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "SOME_PROBLEM_OCCURED_PROCESSING_LIBRARY", ex);
        //return apiError;
      
		// return handleExceptionInternal(ex, apiError, new HttpHeaders(), HttpStatus.CONFLICT, request);
        
        return new ResponseEntity<ApiError>(apiError,  apiError.getStatus());
    }
	
	/*@Override
	   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	       String error = "Malformed JSON request";
	       return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	   }

	   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }
*/

}
