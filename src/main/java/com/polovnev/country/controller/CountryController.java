package com.polovnev.country.controller;

import com.polovnev.country.dto.CountryDto;
import com.polovnev.country.entity.Country;
import com.polovnev.country.facade.CountryFacade;
import com.polovnev.country.service.CustomMessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryFacade countryFacade;

    @Autowired
    private CustomMessageSenderService customMessageSenderService;

    @GetMapping
    public List<CountryDto> getAllCountries() {
        return countryFacade.findAll();
    }

    @GetMapping("/{id}")
    public CountryDto getCountry(@PathVariable Long id) {
        return countryFacade.findById(id);
    }

    @PostMapping()
    public CountryDto addCountry(@RequestBody CountryDto countryDto) {
        CountryDto savedCountry = countryFacade.addCountry(countryDto);
        customMessageSenderService.sendMessage(savedCountry);
        return savedCountry;
    }

    @PutMapping("/{id}")
    public CountryDto updateCountry(@PathVariable Long id, @RequestBody CountryDto countryDto) {
        return countryFacade.updateCountry(id, countryDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
         countryFacade.deleteCountry(id);
    }


}
