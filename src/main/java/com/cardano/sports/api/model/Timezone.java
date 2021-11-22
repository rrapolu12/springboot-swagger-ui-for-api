package com.cardano.sports.api.model;

import com.cardano.sports.api.model.dto.TimezoneDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "timezone")
public class Timezone {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 80, unique = true, nullable = false)
    private String name;

    @Column(name = "offset_t")
    private Integer offset;

    @Column(name = "offset_dst")
    private Integer offset_dst;

    public static Timezone from(final TimezoneDto timezoneDto) {

        Timezone timezone = new Timezone();
        timezone.setId(timezoneDto.getId());
        timezone.setName(timezoneDto.getName());
        timezone.setOffset(timezoneDto.getOffset());
        timezone.setOffset_dst(timezoneDto.getOffset_dst());
        return timezone;
    }
}
