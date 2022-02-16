package com.polovnev.country.service;

import com.polovnev.country.entity.Location;

import java.util.List;

public interface LocationService {

    List<Location> findByCountryId(Long countryId);
}
