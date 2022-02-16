package com.polovnev.location.listener;

import com.polovnev.location.dto.CountryDto;
import com.polovnev.location.facade.CountryFacade;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class CustomMessageListener {

    @Autowired
    private CountryFacade countryFacade;

    //@RabbitListener(queues = "country create")
    public void receiveMessage(final CountryDto countryDto) {
        CountryDto savedCountryDto = countryFacade.addCountry(countryDto);
        System.out.println("Country saved with name: " + savedCountryDto.getName());
    }

    //@RabbitListener(queues = "country delete")
    public void receiveMessage(final Long countryId) {
        countryFacade.deleteCountry(countryId);
        System.out.println("Country deleted with id: " + countryId);
    }
}
