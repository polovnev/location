package com.polovnev.country.controller;

import com.polovnev.country.entity.Country;
import com.polovnev.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/home")
    public List<Country> getCountry() {
        return countryService.findAll();
    }

    @PostMapping("/user")
    public void addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
    }

    @GetMapping("/admin")
    public String getGreetingForAdmin() {
        return "Hello, admin";
    }
}
