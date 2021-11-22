package com.cardano.sports.api.model.dto;

import com.cardano.sports.api.model.Country;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class CountryDto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 80, unique = true, nullable = false)
    private String name;

    @Column(name = "code", length = 2, unique = true, nullable = false)
    private String code;

    @Column(name = "phone_prefix")
    private Integer phonePrefix;

    public static CountryDto from(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        countryDto.setCode(country.getCode());
        countryDto.setPhonePrefix(country.getPhonePrefix());
        return countryDto;
    }
}
