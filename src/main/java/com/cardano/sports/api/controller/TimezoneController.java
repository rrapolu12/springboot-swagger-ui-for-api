package com.cardano.sports.api.controller;

import com.cardano.sports.api.model.Timezone;
import com.cardano.sports.api.model.dto.TimezoneDto;
import com.cardano.sports.api.service.CountryService;
import com.cardano.sports.api.service.TimezoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/timezone")
public class TimezoneController {

    private final TimezoneService timezoneService;

    @Autowired
    public TimezoneController(TimezoneService timezoneService) {
        this.timezoneService = timezoneService;
    }

    @GetMapping
    public ResponseEntity<List<TimezoneDto>> getCountries() {
        List<Timezone> timezones = timezoneService.getTimezones();
        return new ResponseEntity<>(timezones.stream().map(TimezoneDto::from).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TimezoneDto> addTimezone(@RequestBody final TimezoneDto timezoneDto) {
        Timezone timezone = timezoneService.addTimezone(Timezone.from(timezoneDto));
        return new ResponseEntity<>(TimezoneDto.from(timezone), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimezoneDto> getCountry(@PathVariable Long id) {
        Timezone timezone = timezoneService.getTimezone(id);
        return new ResponseEntity<>(TimezoneDto.from(timezone), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TimezoneDto> deleteTimezone(@PathVariable Long id) {
        Timezone timezone = timezoneService.deleteTimezone(id);
        return new ResponseEntity<>(TimezoneDto.from(timezone), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TimezoneDto> editCountry(@PathVariable Long id,
                                                   @RequestBody TimezoneDto timezoneDto) {

        Timezone country = timezoneService.updateTimezone(id, Timezone.from(timezoneDto));
        return new ResponseEntity<>(TimezoneDto.from(country), HttpStatus.OK);
    }

}
