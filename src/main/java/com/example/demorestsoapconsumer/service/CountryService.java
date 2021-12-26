package com.example.demorestsoapconsumer.service;

import com.example.demorestsoapconsumer.client.GetCountryRequest;
import com.example.demorestsoapconsumer.client.GetCountryResponse;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class CountryService extends WebServiceGatewaySupport {


    public GetCountryResponse getCountry(String country) {

        GetCountryRequest getCountryRequest = new GetCountryRequest();
        getCountryRequest.setName(country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", getCountryRequest,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

        return response ;
    }
}
