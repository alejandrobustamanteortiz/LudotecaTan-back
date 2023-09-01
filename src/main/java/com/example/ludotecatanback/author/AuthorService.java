package com.example.ludotecatanback.author;

import com.example.ludotecatanback.author.model.Author;
import com.example.ludotecatanback.author.model.AuthorDto;
import com.example.ludotecatanback.author.model.AuthorSearchDto;
import org.springframework.data.domain.Page;

public interface AuthorService {

    Page<Author> findPage(AuthorSearchDto dto);
    void save(Long id, AuthorDto dto);
    void delete(Long id) throws Exception;
}
