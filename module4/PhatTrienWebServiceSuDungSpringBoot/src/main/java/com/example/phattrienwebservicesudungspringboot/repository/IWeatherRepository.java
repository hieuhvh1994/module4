package com.example.phattrienwebservicesudungspringboot.repository;

import com.example.phattrienwebservicesudungspringboot.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWeatherRepository extends JpaRepository<Weather, Long> {
}
