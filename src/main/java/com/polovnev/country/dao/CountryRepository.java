package com.polovnev.country.dao;

import com.polovnev.country.entity.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> findAll();
}
