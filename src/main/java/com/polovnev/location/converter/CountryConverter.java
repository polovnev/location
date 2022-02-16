package com.polovnev.location.converter;

import com.polovnev.location.dto.CountryDto;
import com.polovnev.location.entity.Country;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Country dtoToEntity(CountryDto countryDto) {
        return modelMapper.map(countryDto, Country.class);
    }

    public CountryDto entityToDto(Country country) {
        return modelMapper.map(country, CountryDto.class);
    }
}
