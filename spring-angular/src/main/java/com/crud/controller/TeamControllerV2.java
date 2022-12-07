package com.crud.controller;

import com.crud.model.TeamV2;
import com.crud.service.TeamServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/team/v2")
public class TeamControllerV2 {

    @Autowired
    private TeamServiceV2 service;

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<TeamV2> findById(@PathVariable long id){
        TeamV2 objetoTeamV2 = this.service.findById(id);
        return ResponseEntity.ok().body(objetoTeamV2);
    }

    @GetMapping(value = "/{team_name}")
    public List<TeamV2> findByName(@PathVariable("team_name")String teamNameV2){
        return service.findByName(teamNameV2);
    }

    @PostMapping(value = "/save")
    public TeamV2 save(@RequestBody TeamV2 teamV1)
    {
        return service.save(teamV1);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TeamV2> update(@PathVariable Long id, @RequestBody TeamV2 obj){
        TeamV2 newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<PagedModel<TeamV2>> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction,
            PagedResourcesAssembler<TeamV2> assembler
    ){
        //.the direction of sort
        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        //.a PageAble object is an object containing the list of resources
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "teamName"));

        //.a Page containing the resource models
        Page<TeamV2> pageModel= service.findAll(pageable);

        //.create the HATEOAS links
        for(TeamV2 team : pageModel){
            buildEntityLinks(team);
        }
        //return the ResponseEntity
        return new ResponseEntity(assembler.toModel(pageModel), HttpStatus.OK);

    }

    private void buildEntityLinks(TeamV2 team) {
    }


}
