package com.cardano.sports.api.model;

import com.cardano.sports.api.model.dto.LanguageDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "language")
public class Language {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 80, unique = true, nullable = false)
    private String name;

    @Column(name = "code", length = 2, unique = true, nullable = false)
    private String code;

    @Column(name = "native", length = 80, unique = true, nullable = false)
    private String nativeStr; // since native is a keyword in java, so appended "Str" to native

    @Column(name = "available")
    private String available;

    public static Language from(LanguageDto languageDto) {
        Language language = new Language();
        language.setId(languageDto.getId());
        language.setCode(languageDto.getCode());
        language.setName(languageDto.getName());
        language.setAvailable(languageDto.getAvailable());
        language.setNativeStr(languageDto.getNativeStr());
        return language;
    }
}
