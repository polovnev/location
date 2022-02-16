package com.polovnev.country.facade;

import com.polovnev.country.converter.LocationConverter;
import com.polovnev.country.dto.LocationDto;
import com.polovnev.country.entity.Location;
import com.polovnev.country.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationFacade {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationConverter locationConverter;


    public List<LocationDto> findByCountryId(Long countryId) {
        return locationService.findByCountryId(countryId).stream()
                .map(locationConverter::entityToDto).collect(Collectors.toList());
    }
}
