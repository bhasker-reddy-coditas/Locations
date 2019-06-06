package com.location;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.location.service.LocationService;
import com.location.service.LocationServiceImpl;

@TestConfiguration
public class LocationResourceTestConfiguration {
    @Bean
    public LocationService myHelper() {
        return  new LocationServiceImpl();
    }
}
