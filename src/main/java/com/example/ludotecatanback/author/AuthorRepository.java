package com.example.ludotecatanback.author;

import com.example.ludotecatanback.author.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Page<Author> findAll(Pageable pageable);
}
