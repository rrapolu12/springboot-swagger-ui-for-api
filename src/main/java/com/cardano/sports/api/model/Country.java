package com.cardano.sports.api.model;

import com.cardano.sports.api.model.dto.CountryDto;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "country")
public class Country implements Serializable {

    public static final Long serialVersionUID = 1L;

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

    public static Country from(CountryDto countryDto) {
        Country country = new Country();
        country.setId(countryDto.getId());
        country.setName(countryDto.getName());
        country.setCode(countryDto.getCode());
        country.setPhonePrefix(countryDto.getPhonePrefix());
        return country;
    }
}
