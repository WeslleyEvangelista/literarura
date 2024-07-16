package br.com.weslley_evantelista.literalura;

import br.com.weslley_evantelista.literalura.model.Author;
import br.com.weslley_evantelista.literalura.model.Book;
import br.com.weslley_evantelista.literalura.service.AuthorService;
import br.com.weslley_evantelista.literalura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Menu {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Escolha o número da sua opção:");
            System.out.println("1- Buscar livro pelo título");
            System.out.println("2- Listar livros registrados");
            System.out.println("3- Listar autores registrados");
            System.out.println("4- Listar livros em um determinado idioma");
            System.out.println("0- Sair");

            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String title = scanner.nextLine();
                    List<Book> booksByTitle = bookService.findBooksByTitle(title);
                    booksByTitle.forEach(book -> System.out.println("ID: " + book.getId() + ", Título: " + book.getTitle()));
                    break;
                case 2:
                    List<Book> allBooks = bookService.findAllBooks();
                    allBooks.forEach(book -> System.out.println("ID: " + book.getId() + ", Título: " + book.getTitle()));
                    break;
                case 3:
                    List<Author> allAuthors = authorService.findAllAuthors();
                    allAuthors.forEach(author -> System.out.println("ID: " + author.getId() + ", Nome: " + author.getName()));
                    break;
                case 4:
                    System.out.print("Digite o idioma (código ISO 639-1): ");
                    String language = scanner.nextLine();
                    List<Book> booksByLanguage = bookService.findBooksByLanguage(language);
                    booksByLanguage.forEach(book -> System.out.println("ID: " + book.getId() + ", Título: " + book.getTitle() + ", Idioma: " + book.getLanguage()));
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (option != 0);

        scanner.close();
    }
}
