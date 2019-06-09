package com.airfare.airfareapp.repository;

import com.airfare.airfareapp.domain.Airfare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirfareRepository extends JpaRepository<Airfare, Integer> {
}
