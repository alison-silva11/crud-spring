package com.crud.service;


import com.crud.model.TeamV1;
import com.crud.model.TeamV2;
import com.crud.repository.TeamRepositoryV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceV1 {

    @Autowired
    private TeamRepositoryV1 repositoryV1;

    public TeamV1 findById(long id){
        Optional<TeamV1> objetoTeam = repositoryV1.findById(id);
        return objetoTeam.orElse(null);
    }
    public List<TeamV1> findAll() {
        return repositoryV1.findAll();
    }

    public TeamV1 save(TeamV1 model)
    {
        return repositoryV1.save(model);
    }

    public TeamV1 update(long id, TeamV2 obj){
        TeamV1 newObj = findById(id);
        newObj.setTeamName(obj.getTeamName());
        newObj.setCreateYear(obj.getCreateYear());
        return repositoryV1.save(newObj);
    }

    public void delete(long id){
        var search = repositoryV1.findById(id);
        if(search.isPresent()){
            repositoryV1.delete(search.get());
        }
    }

    public List<TeamV1> findByName(String teamName){
        return repositoryV1.findByTeamNameContainsIgnoreCaseOrderByTeamName(teamName);
    }

}