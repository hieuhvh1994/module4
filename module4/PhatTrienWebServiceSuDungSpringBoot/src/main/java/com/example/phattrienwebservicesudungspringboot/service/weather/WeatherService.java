package com.example.phattrienwebservicesudungspringboot.service.weather;

import com.example.phattrienwebservicesudungspringboot.model.Weather;
import com.example.phattrienwebservicesudungspringboot.repository.IWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService implements IWeatherService{

    @Autowired
    IWeatherRepository weatherRepository;

    @Override
    public Iterable<Weather> findAll() {
        return weatherRepository.findAll();
    }

    @Override
    public Optional<Weather> findById(Long id) {
        return weatherRepository.findById(id);
    }

    @Override
    public Weather save(Weather weather) {
        return weatherRepository.save(weather);
    }

    @Override
    public void remove(Long id) {
        weatherRepository.deleteById(id);
    }

    @Override
    public Weather findByLocal(String local) {
        Weather weather = null;
        for (Weather w : weatherRepository.findAll()) {
            if (w.getLocal().equals(local)) {
                weather = w;
                break;
            }
        }
        return weather;
    }
}
