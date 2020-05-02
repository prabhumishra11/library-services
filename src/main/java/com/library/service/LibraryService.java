package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Books;
import com.library.entity.Library;
import com.library.exception.BooksException;
import com.library.exception.LibraryException;
import com.library.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	LibraryRepository libraryRepository;
	
	public List<Library> getAllLibrary() {  
		try {
			List<Library> libraryList = new ArrayList<Library>();  
			libraryRepository.findAll().forEach(Library -> libraryList.add(Library));  
			return libraryList;  
		}catch (Exception e) {
			throw new LibraryException("Problem Occured while Fetching Library");
		}
	}  

	public Library getLibraryById(int id) { 
		try {
			return libraryRepository.findById(id).get();  
		}catch (Exception e) {
			throw new LibraryException("Problem Occured while fetching Library for Id - " +id);
		}
	}  
	
	public Library save(Library library) { 
		try {
			return libraryRepository.save(library);  
		}catch (Exception e) {
			throw new LibraryException("Problem Occured while Saving Library");
		}
	}  

	public void delete(int id)  { 
		try {
			libraryRepository.deleteById(id);  
		}catch (Exception e) {
			throw new LibraryException("Problem Occured while Deleting Library");
		}
	}  

	public Library update(Library library) {  
		try {
			return libraryRepository.save(library);  
		}catch (Exception e) {
			throw new LibraryException("Problem Occured while Updating Library");
		}
	}  

}
