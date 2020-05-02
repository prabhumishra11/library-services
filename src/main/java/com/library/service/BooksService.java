package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Books;
import com.library.exception.BooksException;
import com.library.repository.BooksRepository;

@Service
public class BooksService {
	
	@Autowired
	BooksRepository booksRepository;
	
	public List<Books> getAllBooks()  {  
		try {
			List<Books> books = new ArrayList<Books>();  
			booksRepository.findAll().forEach(books1 -> books.add(books1));  
			return books;  
		}catch (Exception e) {
			throw new BooksException("Problem Occured while fetching Books");
		}
		
	}  


	public Books getBookById(int id) {  
		try {
			
			return booksRepository.findById(id).get();  
	
		}catch (Exception e) {
			throw new BooksException("Problem Occured while fetching Book for Id -"+id);
		}
	}  
	
	public Books save(Books books) { 
		try {
			return booksRepository.save(books); 
		}catch (Exception e) {
			throw new BooksException("Problem Occured while saving Book");
		}
	}  

	public void delete(int id)  {  
		try {
			booksRepository.deleteById(id);  
		}catch (Exception e) {
			throw new BooksException("Problem Occured while deleting Book");
		}
	}  

	public Books update(Books books) {  
		try {
			return booksRepository.save(books);  
		}catch (Exception e) {
			throw new BooksException("Problem Occured while Updating Book");
		}
	}  

}
