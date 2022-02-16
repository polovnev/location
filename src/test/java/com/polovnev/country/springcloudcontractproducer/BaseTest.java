package com.polovnev.country.springcloudcontractproducer;

import com.polovnev.country.controller.CountryController;

import com.polovnev.country.dao.CountryRepository;
import com.polovnev.country.entity.Country;
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

    @MockBean
    private CountryRepository countryRepository;

    @BeforeEach
    public void setup() {
        setupDbInteraction();
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(countryController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

    private void setupDbInteraction() {
        Country countryOne = Country.builder().id(1L).name("countryOne")
                .build();
        Country countryTwo = Country.builder().id(2L).name("countryTwo")
                .build();
        List<Country> countries = Arrays.asList(countryOne, countryTwo);
        Mockito.when(countryRepository.findAll()).thenReturn(countries);
    }
}
