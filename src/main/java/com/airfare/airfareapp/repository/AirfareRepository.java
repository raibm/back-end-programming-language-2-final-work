package com.airfare.airfareapp.repository;

import com.airfare.airfareapp.domain.Airfare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirfareRepository extends JpaRepository<Airfare, Integer> {
    List<Airfare> findById(int id);

}
