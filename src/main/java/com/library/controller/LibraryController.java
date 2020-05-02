package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Library;
import com.library.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
	
	
			@Autowired
			LibraryService libraryService;

			@RequestMapping(value = "", method=RequestMethod.GET)
			public ResponseEntity<List<Library>> getAllLibrary(){
					return ResponseEntity.ok(libraryService.getAllLibrary());
			}
			
			@RequestMapping(value = "/{id}", method=RequestMethod.GET)
			public ResponseEntity<Library> getLibraryById(@PathVariable(value="id") int libraryId ){
					return ResponseEntity.ok(libraryService.getLibraryById(libraryId));
			}
			
			@RequestMapping(value = "", method=RequestMethod.POST)
			public ResponseEntity<Library> saveBook(@RequestBody Library library){
					return ResponseEntity.ok(libraryService.save(library));
			}
			
			@RequestMapping(value = "", method=RequestMethod.PUT)
			public ResponseEntity<Library> updateBook(@RequestBody Library library){
					return ResponseEntity.ok(libraryService.update(library));
			}
			
			@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
			public void deleteBook(@PathVariable(value="id") int libraryId ){
				libraryService.delete(libraryId);
			}
}
