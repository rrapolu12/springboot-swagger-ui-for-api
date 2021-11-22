package com.cardano.sports.api.controller;

import com.cardano.sports.api.model.Language;
import com.cardano.sports.api.model.dto.LanguageDto;
import com.cardano.sports.api.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/language")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getLanguages() {
        List<Language> languages = languageService.getLanguages();
        return new ResponseEntity<>(languages.stream().map(LanguageDto::from).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LanguageDto> addLanguage(@RequestBody final LanguageDto languageDto) {
        Language language = languageService.addLanguage(Language.from(languageDto));
        return new ResponseEntity<>(LanguageDto.from(language), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<LanguageDto> getLanguage(@PathVariable Long id) {
        Language Language = languageService.getLanguage(id);
        return new ResponseEntity<>(LanguageDto.from(Language), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<LanguageDto> deleteLanguage(@PathVariable Long id) {
        Language language = languageService.deleteLanguage(id);
        return new ResponseEntity<>(LanguageDto.from(language), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<LanguageDto> editLanguage(@PathVariable Long id,
                                                    @RequestBody LanguageDto languageDto) {

        Language language = languageService.updateLanguage(id, Language.from(languageDto));
        return new ResponseEntity<>(LanguageDto.from(language), HttpStatus.OK);
    }

}
