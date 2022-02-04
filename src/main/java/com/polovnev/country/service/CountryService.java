package com.polovnev.country.service;

import com.polovnev.country.entity.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();

    void addCountry(Country country);

}
