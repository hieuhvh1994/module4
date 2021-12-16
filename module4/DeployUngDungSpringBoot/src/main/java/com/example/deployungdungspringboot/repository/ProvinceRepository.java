package com.example.deployungdungspringboot.repository;

import com.example.deployungdungspringboot.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends CrudRepository<Province, Long> {
}
