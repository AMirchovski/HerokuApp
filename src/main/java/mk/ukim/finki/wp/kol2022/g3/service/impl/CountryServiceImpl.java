package mk.ukim.finki.wp.kol2022.g3.service.impl;

import mk.ukim.finki.wp.kol2022.g3.model.Country;
import mk.ukim.finki.wp.kol2022.g3.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.wp.kol2022.g3.repository.CountryRepository;
import mk.ukim.finki.wp.kol2022.g3.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country(name, continent);
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> edit(Long id, String name, String continent) {
        Country country = this.countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
        country.setContinent(continent);
        country.setName(name);
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public void delete(Long id) {
        Country country = this.countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
        this.countryRepository.delete(country);
    }
}
