package com.airfare.airfareapp.controllers;

import com.airfare.airfareapp.domain.Airfare;
import com.airfare.airfareapp.repository.AirfareRepository;
import com.airfare.airfareapp.service.ServiceImpl;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/airfare"})
public class AirfareController {

    private final ServiceImpl service;

    public AirfareController(ServiceImpl service){
        this.service = service;
    }

    @GetMapping("/international")
    public List<Airfare> findAllAirfareInternational(){
        return service.getAirfareInternational();
    }

    @GetMapping("/national")
    public List<Airfare> findAllAirfareNational(){
        return service.getAirfareNational();
    }

    @GetMapping()
    public List<Airfare> getAllAirfares(){
        return service.myAirfares();
    }

    @GetMapping(path = "{id}")
    public Optional<Airfare> getAirfareById(@PathVariable("id") int id){
        return service.getAirfareById(id);
    }

    @PostMapping()
    public Airfare addAirFare(@RequestBody Airfare a){
       return service.addAirfare(a);
    }

    @PutMapping(path = "{id}")
    public Airfare editAirfare(@RequestBody Airfare a, @PathVariable("id") int id ){
        a.setId(id);
        return service.editAirfare(a);
    }

    @DeleteMapping("/{id}")
    public void deleteAirfareById(@PathVariable("id") int id){
        service.deleteAirfareById(id);
    }

}
