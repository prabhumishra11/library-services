package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Books;
import com.library.service.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	
			@Autowired
			BooksService booksService;
			
			@RequestMapping(value = "", method=RequestMethod.GET)
			public ResponseEntity<List<Books>> getAllBooks(){
					return ResponseEntity.ok(booksService.getAllBooks());
			}
			
			@RequestMapping(value = "/{id}", method=RequestMethod.GET)
			public ResponseEntity<Books> getBookById(@PathVariable(value="id") int bookId ){
					return ResponseEntity.ok(booksService.getBookById(bookId));
			}
			
			@RequestMapping(value = "", method=RequestMethod.POST)
			public ResponseEntity<Books> saveBook(@RequestBody Books books){
					return ResponseEntity.ok(booksService.save(books));
			}
			
			@RequestMapping(value = "", method=RequestMethod.PUT)
			public ResponseEntity<Books> updateBook(@RequestBody Books books){
					return ResponseEntity.ok(booksService.update(books));
			}
			
			@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
			public void deleteBook(@PathVariable(value="id") int bookId ){
					booksService.delete(bookId);
			}
			

}
