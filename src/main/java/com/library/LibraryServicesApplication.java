package com.library;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.library.entity.Books;
import com.library.entity.Library;
import com.library.repository.BooksRepository;
import com.library.repository.LibraryRepository;

@SpringBootApplication
@CrossOrigin 
public class LibraryServicesApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(LibraryServicesApplication.class);
	
	@Autowired
    private LibraryRepository libraryRepository;
	
	@Autowired
    private BooksRepository booksRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryServicesApplication.class, args);
	}
	
	@Override
    public void run(String... args) {

		LOGGER.info("Loading Initial Data for Library and Books Entity...");
		
		Library library = new Library();
		library.setName("Nobels_Library");
		libraryRepository.save(library);
		
		List<Books> books = Arrays.asList(new Books(library,"Two States" , "Chetan Bhagat"), new Books(library,"The Monk Who Sold His Ferrari" , "Robin Sharma"));

		booksRepository.saveAll(books);
		LOGGER.info("Loaded Initial Data for Library and Books Entity...");
    }


}
