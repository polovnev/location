package com.polovnev.location.dao;

import com.polovnev.location.entity.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {

    List<Location> findByCountry_Id(Long countryId);

}
