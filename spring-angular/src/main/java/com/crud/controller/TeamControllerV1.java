package com.crud.controller;


import com.crud.model.TeamV1;
import javax.validation.Valid;

import com.crud.model.TeamV2;
import com.crud.service.TeamServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/team/v1")
public class TeamControllerV1 {

    @Autowired
    private TeamServiceV1 service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TeamV1> findById(@PathVariable long id){
        TeamV1 objetoTeamV1 = this.service.findById(id);
        return ResponseEntity.ok().body(objetoTeamV1);
    }

    @GetMapping(value = "/find/{team_name}")
    public List<TeamV1> findByName(@PathVariable("team_name")String teamNameV1){
        return service.findByName(teamNameV1);
    }

    @GetMapping
    private List<TeamV1> findAll()
    {
        return service.findAll();
    }

    @PostMapping(value = "/save")
    public TeamV1 save(@RequestBody @Valid TeamV1 teamV1) {
        return service.save(teamV1);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TeamV1> update(@PathVariable Long id, @RequestBody TeamV2 obj){
        TeamV1 newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
