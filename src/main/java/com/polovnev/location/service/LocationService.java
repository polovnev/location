package com.polovnev.location.service;

import com.polovnev.location.entity.Location;

import java.util.List;

public interface LocationService {

    List<Location> findByCountryId(Long countryId);
}
