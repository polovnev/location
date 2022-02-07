package com.polovnev.country.facade;

import com.polovnev.country.converter.CountryConverter;
import com.polovnev.country.dto.CountryDto;
import com.polovnev.country.entity.Country;
import com.polovnev.country.service.CountryService;
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
                .map(countryConverter::entityToCountryDto).collect(Collectors.toList());
    }

    public CountryDto findById(Long id) {
        Country country = countryService.findById(id);
        return countryConverter.entityToCountryDto(country);
    }

    public CountryDto addCountry(CountryDto countryDto) {
        Country country = countryConverter.dtoToEntity(countryDto);
        Country savedCountry = countryService.addCountry(country);
        return countryConverter.entityToCountryDto(savedCountry);
    }

    public CountryDto updateCountry(Long id, CountryDto countryDto) {
        Country country = countryConverter.dtoToEntity(countryDto);
        Country savedCountry = countryService.updateCountry(id, country);
        return countryConverter.entityToCountryDto(savedCountry);
    }

    public void deleteCountry(Long id) {
        countryService.deleteCountry(id);
    }
}
