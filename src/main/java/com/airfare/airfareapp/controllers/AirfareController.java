package com.airfare.airfareapp.controllers;

import com.airfare.airfareapp.domain.Airfare;
import com.airfare.airfareapp.repository.AirfareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/airfare"})
public class AirfareController {

    @Autowired
    AirfareRepository airfareRepository;

    @GetMapping(path = "/{id}")
    public List<Airfare> findAllAirfareById(@PathVariable("id") int id){
        return airfareRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAirfareById(@PathVariable("id") int id){
        airfareRepository.deleteById(id);
    }

}
