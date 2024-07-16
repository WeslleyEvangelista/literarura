package br.com.weslley_evantelista.literalura.controller;

import br.com.weslley_evantelista.literalura.model.Book;
import br.com.weslley_evantelista.literalura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String title) {
        return bookService.findBooksByTitle(title);
    }

    @GetMapping
    public List<Book> listBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/language")
    public List<Book> listBooksByLanguage(@RequestParam String language) {
        return bookService.findBooksByLanguage(language);
    }
}
