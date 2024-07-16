package br.com.weslley_evantelista.literalura.repository;

import br.com.weslley_evantelista.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
