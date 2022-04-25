package mk.ukim.finki.wp.kol2022.g3.service;

import java.util.*;
import mk.ukim.finki.wp.kol2022.g3.model.Author;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save (String name, String surname, Long countryId);

    Optional<Author> edit (Long id, String name, String surname, Long countryId);

    void delete (Long id);
}
