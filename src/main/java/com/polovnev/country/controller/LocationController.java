package com.polovnev.country.controller;

import com.polovnev.country.dto.LocationDto;
import com.polovnev.country.facade.LocationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country/{countryId}/location")
public class LocationController {

    @Autowired
    private LocationFacade locationFacade;

    @GetMapping
    public List<LocationDto> findByCountryId(@PathVariable Long countryId) {
        return locationFacade.findByCountryId(countryId);
    }
}
