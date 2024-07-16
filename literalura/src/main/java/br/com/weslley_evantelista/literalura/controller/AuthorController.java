package br.com.weslley_evantelista.literalura.controller;


import br.com.weslley_evantelista.literalura.model.Author;
import br.com.weslley_evantelista.literalura.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> listAuthors() {
        return authorService.findAllAuthors();
    }
}
