package com.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer> {

}
