package com.crudspring.controller;

import com.crudspring.model.League;
import com.crudspring.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/league")
public class LeagueController {

    @Autowired
    private LeagueService service;

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<League> findById(@PathVariable long id){
        League objetoLeague = this.service.findById(id);
        return ResponseEntity.ok().body(objetoLeague);
    }

    @GetMapping(value = "/{league_name}")
    public List<League> findByName(@PathVariable("league_name")String league_name){
        return service.findByName(league_name);
    }

    @GetMapping
    private List<League> findAll(){
        return service.findAll();
    }

    @PostMapping
    public League save(@RequestBody League model){
        return service.save(model);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<League> update(@PathVariable Long id, @RequestBody League obj){
        League newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}