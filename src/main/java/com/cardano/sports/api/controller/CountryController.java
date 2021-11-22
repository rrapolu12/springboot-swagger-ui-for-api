package com.cardano.sports.api.controller;

import com.cardano.sports.api.model.Country;
import com.cardano.sports.api.model.dto.CountryDto;
import com.cardano.sports.api.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<CountryDto>> getCountries() {
        List<Country> countries = countryService.getCountries();
        return new ResponseEntity<>(countries.stream().map(CountryDto::from).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CountryDto> addCountry(@RequestBody final CountryDto countryDto) {
        Country country = countryService.addCountry(Country.from(countryDto));
        return new ResponseEntity<>(CountryDto.from(country), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CountryDto> getCountry(@PathVariable Long id) {
        Country country = countryService.getCountry(id);
        return new ResponseEntity<>(CountryDto.from(country), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CountryDto> deleteCountry(@PathVariable Long id) {
        Country country = countryService.deleteCountry(id);
        return new ResponseEntity<>(CountryDto.from(country), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CountryDto> editCountry(@PathVariable Long id,
                                                  @RequestBody CountryDto countryDto) {

        Country country = countryService.updateCountry(id, Country.from(countryDto));
        return new ResponseEntity<>(CountryDto.from(country), HttpStatus.OK);
    }

}
