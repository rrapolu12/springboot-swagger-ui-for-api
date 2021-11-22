package com.cardano.sports.api.service;

import com.cardano.sports.api.model.Timezone;
import com.cardano.sports.api.model.exception.TimezoneNotFoundException;
import com.cardano.sports.api.repository.TimezoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TimezoneService {

    private final TimezoneRepository timezoneRepository;

    @Autowired
    public TimezoneService(TimezoneRepository timezoneRepository) {
        this.timezoneRepository = timezoneRepository;
    }


    public List<Timezone> getTimezones() {

        List<Timezone> timezones =
                StreamSupport.stream(timezoneRepository.findAll().spliterator(), false).collect(Collectors.toList());
        return timezones;
    }

    public Timezone getTimezone(Long id) {
        return timezoneRepository
                .findById(id)
                .orElseThrow(() -> new TimezoneNotFoundException(id));
    }

    public Timezone addTimezone(Timezone timezone) {
        return timezoneRepository.save(timezone);
    }

    public Timezone deleteTimezone(Long id) {
        Timezone timezone = getTimezone(id);
        timezoneRepository.delete(timezone);
        return timezone;
    }

    @Transactional
    public Timezone updateTimezone(Long id,
                                   Timezone timezone) {

        Timezone timezoneToUpdate = getTimezone(id);
        timezoneToUpdate.setName(timezone.getName());
        timezoneToUpdate.setOffset(timezone.getOffset());
        timezoneToUpdate.setOffset_dst(timezone.getOffset_dst());
        return timezoneToUpdate;
    }
}
