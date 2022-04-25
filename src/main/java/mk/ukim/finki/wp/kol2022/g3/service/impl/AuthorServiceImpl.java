package mk.ukim.finki.wp.kol2022.g3.service.impl;

import mk.ukim.finki.wp.kol2022.g3.model.Author;
import mk.ukim.finki.wp.kol2022.g3.model.Country;
import mk.ukim.finki.wp.kol2022.g3.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.wp.kol2022.g3.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.wp.kol2022.g3.repository.AuthorRepository;
import mk.ukim.finki.wp.kol2022.g3.repository.CountryRepository;
import mk.ukim.finki.wp.kol2022.g3.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException(countryId));
        Author author = new Author(name, surname, country);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long id, String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException(countryId));
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        author.setName(name);
        author.setCountry(country);
        author.setSurname(surname);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void delete(Long id) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        this.authorRepository.delete(author);
    }
}
