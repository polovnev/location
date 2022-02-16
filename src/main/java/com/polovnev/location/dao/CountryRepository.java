package com.polovnev.location.dao;

import com.polovnev.location.entity.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> findAll();
}
