package com.cardano.sports.api.model.dto;

import com.cardano.sports.api.model.Language;
import lombok.Data;

@Data
public class LanguageDto {

    private Long id;

    private String name;

    private String code;

    private String nativeStr; // since native is a keyword in java, so appended "Str" to native

    private String available;

    public static LanguageDto from(Language language) {
        LanguageDto languageDto = new LanguageDto();
        languageDto.setId(language.getId());
        languageDto.setCode(language.getCode());
        languageDto.setName(language.getName());
        languageDto.setAvailable(language.getAvailable());
        languageDto.setNativeStr(language.getNativeStr());
        return languageDto;
    }
}
