package com.polovnev.location.springcloudcontractproducer;

import com.polovnev.location.controller.CountryController;

import com.polovnev.location.controller.LocationController;
import com.polovnev.location.dao.CountryRepository;
import com.polovnev.location.dao.LocationRepository;
import com.polovnev.location.entity.Country;
import com.polovnev.location.entity.Location;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
public class BaseTest {

    @Autowired
    private CountryController countryController;

    @Autowired
    private LocationController locationController;

    @MockBean
    private CountryRepository countryRepository;

    @MockBean
    private LocationRepository locationRepository;

    @BeforeEach
    public void setup() {
        setupDbInteraction();
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(countryController, locationController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

    private void setupDbInteraction() {
        Country countryOne = Country.builder().id(1L).name("countryOne")
                .build();
        Country countryTwo = Country.builder().id(2L).name("countryTwo")
                .build();
        List<Country> countries = Arrays.asList(countryOne, countryTwo);
        Mockito.when(countryRepository.findAll()).thenReturn(countries);

        Location locationOne = Location.builder().id(1L).name("LocationOneForCountryOne")
                .country(countryOne).build();
        Location locationTwo = Location.builder().id(2L).name("LocationTwoForCountryOne")
                .country(countryOne).build();
        List<Location> locations = Arrays.asList(locationOne, locationTwo);
        Mockito.when(locationRepository.findByCountry_Id(1L)).thenReturn(locations);
    }
}
