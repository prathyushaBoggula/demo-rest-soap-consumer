package com.example.demorestsoapconsumer.controller;

import com.example.demorestsoapconsumer.client.GetCountryResponse;
import com.example.demorestsoapconsumer.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService ;

    @GetMapping("/country")
    public GetCountryResponse getCountry(@RequestParam String country) {
        GetCountryResponse  getCountryResponse =  countryService.getCountry(country);

        return getCountryResponse ;
    }
}
