package com.polovnev.country.converter;

import com.polovnev.country.dto.LocationDto;
import com.polovnev.country.entity.Location;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Location dtoToEntity(LocationDto locationDto) {
        return modelMapper.map(locationDto, Location.class);
    }

    public LocationDto entityToDto(Location location) {
        return modelMapper.map(location, LocationDto.class);
    }
}
