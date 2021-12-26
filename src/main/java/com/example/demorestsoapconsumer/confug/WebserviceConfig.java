package com.example.demorestsoapconsumer.confug;

import com.example.demorestsoapconsumer.service.CountryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WebserviceConfig {


    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.example.demorestsoapconsumer.client");
        return marshaller;
    }

    @Bean
    public CountryService countryClient(Jaxb2Marshaller marshaller) {
        CountryService service = new CountryService();
        service.setDefaultUri("http://localhost:8080/ws");
        service.setMarshaller(marshaller);
        service.setUnmarshaller(marshaller);
        return service;
    }

}
