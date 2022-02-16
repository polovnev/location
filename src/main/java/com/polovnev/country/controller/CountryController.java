package com.polovnev.country.controller;


import com.polovnev.country.dto.CountryDto;
import com.polovnev.country.facade.CountryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryFacade countryFacade;

    @GetMapping
    public List<CountryDto> getAllCountries() {
        return countryFacade.findAll();
    }

    @GetMapping("/{id}")
    public CountryDto getCountry(@PathVariable Long id) {
        return countryFacade.findById(id);
    }

    @PostMapping
    public CountryDto addCountry(@RequestBody CountryDto countryDto) {
        return countryFacade.addCountry(countryDto);
    }

}
