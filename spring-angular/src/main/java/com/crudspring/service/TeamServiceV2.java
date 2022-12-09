package com.crudspring.service;

import com.crudspring.model.TeamV2;
import com.crudspring.repository.TeamRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceV2 {

    @Autowired

    private TeamRepositoryV2 repositoryV2;

    public TeamV2 findById(long id){
        Optional<TeamV2> objetoTeamV2 = repositoryV2.findById(id);
        return objetoTeamV2.orElse(null);
    }

    public Page<TeamV2> findAll(Pageable pageable) {return repositoryV2.findAll(pageable);}

    public TeamV2 save(TeamV2 modelV2)
    {
        return repositoryV2.save(modelV2);
    }

    public TeamV2 update(long id, TeamV2 obj){
        TeamV2 newObj = findById(id);
        newObj.setTeamName(obj.getTeamName());
        newObj.setCreateYear(obj.getCreateYear());
        newObj.setTeamAwards(obj.getTeamAwards());
        newObj.setTeamNickname(obj.getTeamNickname());
        newObj.setTeamCity(obj.getTeamCity());
        newObj.setLeague(newObj.getLeague());
        return repositoryV2.save(newObj);
    }

    public void delete(long id){
        var search = repositoryV2.findById(id);
        if(search.isPresent()){
            repositoryV2.delete(search.get());
        }
    }

    public List<TeamV2> findByName(String teamNameV2){
        return repositoryV2.findByTeamNameContainsIgnoreCaseOrderByTeamName(teamNameV2);
    }
}
