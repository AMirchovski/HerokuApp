package mk.ukim.finki.wp.kol2022.g3.service;

import mk.ukim.finki.wp.kol2022.g3.model.Book;
import mk.ukim.finki.wp.kol2022.g3.model.BookDto;
import mk.ukim.finki.wp.kol2022.g3.model.Category;

import java.util.*;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save (String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> save (BookDto bookDto);

    Optional<Book> edit (Long id, String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById (Long id);
}
