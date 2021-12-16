package com.example.phattrienwebservicesudungspringboot.service.weather;

import com.example.phattrienwebservicesudungspringboot.model.Weather;
import com.example.phattrienwebservicesudungspringboot.service.IGeneralService;

import java.util.Optional;

public interface IWeatherService extends IGeneralService<Weather> {
    Weather findByLocal(String local);
}
