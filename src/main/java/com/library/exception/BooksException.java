package com.library.exception;

public class BooksException extends RuntimeException { 
	public BooksException(String errorMessage) {
        super(errorMessage);
    }
}
