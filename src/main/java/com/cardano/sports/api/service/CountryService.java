package com.cardano.sports.api.service;

import com.cardano.sports.api.model.exception.CountryNotFoundException;
import com.cardano.sports.api.model.Country;
import com.cardano.sports.api.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    public List<Country> getCountries() {

        List<Country> countries =
                StreamSupport.stream(countryRepository.findAll().spliterator(), false).collect(Collectors.toList());
        return countries;
    }

    public Country getCountry(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country deleteCountry(Long id) {
        Country country = getCountry(id);
        countryRepository.delete(country);
        return country;
    }

    @Transactional
    public Country updateCountry(Long id,
                              Country country) {

        Country countryToUpdate = getCountry(id);
        countryToUpdate.setCode(country.getCode());
        countryToUpdate.setName(country.getName());
        countryToUpdate.setPhonePrefix(country.getPhonePrefix());
        return countryToUpdate;
    }
}
