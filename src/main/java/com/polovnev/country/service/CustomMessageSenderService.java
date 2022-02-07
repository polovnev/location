package com.polovnev.country.service;


import com.polovnev.country.dto.CountryDto;

public interface CustomMessageSenderService {

    void sendMessage(CountryDto countryDto);
}
