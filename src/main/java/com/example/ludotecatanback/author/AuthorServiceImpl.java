package com.example.ludotecatanback.author;

import com.example.ludotecatanback.author.model.Author;
import com.example.ludotecatanback.author.model.AuthorDto;
import com.example.ludotecatanback.author.model.AuthorSearchDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author get(Long id) {

        return this.authorRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Author> findPage(AuthorSearchDto dto) {
        return this.authorRepository.findAll(dto.getPageable().getPageable());
    }

    @Override
    public void save(Long id, AuthorDto data) {

        Author author;

        if (id == null) {
            author = new Author();
        } else {
            author = author = this.get(id);
        }

        BeanUtils.copyProperties(data, author, "id");

        this.authorRepository.save(author);

    }

    @Override
    public void delete(Long id) throws Exception {

        if(this.get(id) == null){
            throw new Exception("Not exists");
        }

        this.authorRepository.deleteById(id);

    }
}
