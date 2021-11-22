package com.cardano.sports.api.service;

import com.cardano.sports.api.model.Language;
import com.cardano.sports.api.model.exception.LanguageNotFoundException;
import com.cardano.sports.api.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }


    public List<Language> getLanguages() {

        List<Language> countries =
                StreamSupport.stream(languageRepository.findAll().spliterator(), false).collect(Collectors.toList());
        return countries;
    }

    public Language getLanguage(Long id) {
        return languageRepository.findById(id).orElseThrow(
                () -> new LanguageNotFoundException(id));
    }

    public Language addLanguage(Language language) {
        return languageRepository.save(language);
    }

    public Language deleteLanguage(Long id) {
        Language language = getLanguage(id);
        languageRepository.delete(language);
        return language;
    }

    @Transactional
    public Language updateLanguage(Long id,
                                   Language language) {

        Language languageToUpdate = getLanguage(id);
        languageToUpdate.setCode(language.getCode());
        languageToUpdate.setName(language.getName());
        languageToUpdate.setAvailable(language.getAvailable());
        languageToUpdate.setNativeStr(language.getNativeStr());
        return languageToUpdate;
    }
}
