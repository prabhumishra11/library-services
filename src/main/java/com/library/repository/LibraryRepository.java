package com.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Library;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Integer> {

}
