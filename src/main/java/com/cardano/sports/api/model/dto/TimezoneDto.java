package com.cardano.sports.api.model.dto;

import com.cardano.sports.api.model.Timezone;
import lombok.Data;

@Data
public class TimezoneDto {

    private Long id;
    private String name;
    private Integer offset;
    private Integer offset_dst;

    public static TimezoneDto from(Timezone timezone) {
        TimezoneDto timezoneDto = new TimezoneDto();
        timezoneDto.setId(timezone.getId());
        timezoneDto.setName(timezone.getName());
        timezoneDto.setOffset(timezone.getOffset());
        timezoneDto.setOffset_dst(timezone.getOffset_dst());
        return timezoneDto;
    }
}
