package com.polovnev.country.service.impl;

import com.polovnev.country.dao.CountryRepository;
import com.polovnev.country.entity.Country;
import com.polovnev.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public void addCountry(Country country) {
        countryRepository.save(country);
    }
}
