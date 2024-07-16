package br.com.weslley_evantelista.literalura.repository;

import br.com.weslley_evantelista.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByLanguage(String language);
}