package com.polovnev.country.service.impl;

import com.polovnev.country.dao.LocationRepository;
import com.polovnev.country.entity.Location;
import com.polovnev.country.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> findByCountryId(Long countryId) {
        return locationRepository.findByCountry_Id(countryId);
    }
}
