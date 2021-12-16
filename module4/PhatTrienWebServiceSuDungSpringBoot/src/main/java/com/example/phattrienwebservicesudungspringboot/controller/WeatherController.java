package com.example.phattrienwebservicesudungspringboot.controller;

import com.example.phattrienwebservicesudungspringboot.model.Weather;
import com.example.phattrienwebservicesudungspringboot.service.weather.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    IWeatherService weatherService;

    @GetMapping("/weather/{username}/{password}/{location}")
    public ResponseEntity<Weather> getWeatherDescription(@PathVariable String username, @PathVariable String password, @PathVariable String location) {
        if (username.equals("hieu") && password.equals("123")) {
            Weather weather= weatherService.findByLocal(location);
            if (weather != null) {
                return new ResponseEntity<>(weather, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
