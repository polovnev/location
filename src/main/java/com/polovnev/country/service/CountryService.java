package com.polovnev.country.service;

import com.polovnev.country.entity.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();

    Country findById(Long id);

    Country addCountry(Country country);

    Country updateCountry(Long id, Country country);

    void deleteCountry(Long id);

}
