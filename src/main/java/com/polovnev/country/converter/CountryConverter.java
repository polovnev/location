package com.polovnev.country.converter;

import com.polovnev.country.dto.CountryDto;
import com.polovnev.country.entity.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryConverter {

    public Country dtoToEntity(CountryDto countryDto) {
        return new Country(countryDto.getId(), countryDto.getName());
    }

    public CountryDto entityToCountryDto(Country country) {
        return new CountryDto(country.getId(), country.getName());
    }
}
