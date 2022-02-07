package com.polovnev.country.controller;

import com.polovnev.country.entity.Country;
import com.polovnev.country.service.CountryService;
import com.polovnev.country.service.CustomMessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CustomMessageSenderService customMessageSenderService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public Country getCountry(@PathVariable Long id) {
        return countryService.findById(id);
    }

    @PostMapping()
    public Country addCountry(@RequestBody Country country) {
        Country savedCountry = countryService.addCountry(country);
        customMessageSenderService.sendMessage(savedCountry);
        return savedCountry;
    }

    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable Long id, @RequestBody Country country) {
        return countryService.updateCountry(id, country);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
         countryService.deleteCountry(id);
    }


}
