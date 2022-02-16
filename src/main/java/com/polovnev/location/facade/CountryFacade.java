package com.polovnev.location.facade;

import com.polovnev.location.converter.CountryConverter;
import com.polovnev.location.dto.CountryDto;
import com.polovnev.location.entity.Country;
import com.polovnev.location.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryFacade {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryConverter countryConverter;

    public List<CountryDto> findAll() {
        return countryService.findAll().stream()
                .map(countryConverter::entityToDto).collect(Collectors.toList());
    }

    public CountryDto findById(Long id) {
        Country country = countryService.findById(id);
        return countryConverter.entityToDto(country);
    }

    public CountryDto addCountry(CountryDto countryDto) {
        Country country = countryConverter.dtoToEntity(countryDto);
        Country savedCountry = countryService.addCountry(country);
        return countryConverter.entityToDto(savedCountry);
    }

    public CountryDto updateCountry(Long id, CountryDto countryDto) {
        Country country = countryConverter.dtoToEntity(countryDto);
        Country savedCountry = countryService.updateCountry(id, country);
        return countryConverter.entityToDto(savedCountry);
    }

    public void deleteCountry(Long id) {
        countryService.deleteCountry(id);
    }
}
