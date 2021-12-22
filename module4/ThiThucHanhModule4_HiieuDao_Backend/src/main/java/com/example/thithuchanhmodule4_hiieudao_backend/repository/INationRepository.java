package com.example.thithuchanhmodule4_hiieudao_backend.repository;

import com.example.thithuchanhmodule4_hiieudao_backend.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INationRepository extends JpaRepository<Nation, Long> {
}
