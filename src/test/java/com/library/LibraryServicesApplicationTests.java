package com.library;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.library.controller.BooksController;
import com.library.entity.Books;
import com.library.service.BooksService;

@SpringBootTest
class LibraryServicesApplicationTests {

	@InjectMocks
	BooksController booksController;
	
    @Mock
	private BooksService booksService;
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSave() throws JsonProcessingException {
	    	    	
	   	Books book = new Books();
		book.setId(1);
		
		Mockito.when(booksService.save(book)).thenReturn(book);
		Books savedBooks = booksService.save(book);
		
		Assert.isTrue(Objects.nonNull(savedBooks.getId()));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testUpdate() throws JsonProcessingException {
	    	    	
	   	Books book = new Books();
	   	book.setTitle("Test");
	   	book.setId(1);
		
		Mockito.when(booksService.update(book)).thenReturn(book);
		Books updatedBooks = booksService.update(book);
		
		Assert.isTrue(updatedBooks.getTitle().equals("Test"));
	}
	
	
}
