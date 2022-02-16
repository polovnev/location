package com.polovnev.location.facade;

import com.polovnev.location.converter.LocationConverter;
import com.polovnev.location.dto.LocationDto;
import com.polovnev.location.service.LocationService;
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
