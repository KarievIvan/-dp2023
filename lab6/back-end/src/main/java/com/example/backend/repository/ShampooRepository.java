package com.example.backend.repository;

import com.example.backend.entity.ShampooEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShampooRepository extends JpaRepository<ShampooEntity, Long> {
}
