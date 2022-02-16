package com.polovnev.country.dao;

import com.polovnev.country.entity.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {

    List<Location> findByCountry_Id(Long countryId);

}
