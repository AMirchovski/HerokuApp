package mk.ukim.finki.wp.kol2022.g3.service;

import mk.ukim.finki.wp.kol2022.g3.model.Country;

import java.util.*;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save (String name, String continent);

    Optional<Country> edit (Long id, String name, String continent);

    void delete (Long id);
}
