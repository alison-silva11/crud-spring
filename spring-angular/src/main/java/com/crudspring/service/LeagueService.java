package com.crudspring.service;

import com.crudspring.model.League;
import com.crudspring.model.TeamV1;
import com.crudspring.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {

    @Autowired

    private LeagueRepository repository;

    public League findById(long id){
        Optional<League> objetoLeague = repository.findById(id);
        return objetoLeague.orElse(null);
    }
    public List<League> findAll() {
        return repository.findAll();
    }

    public League save(League model)
    {
        return repository.save(model);
    }

    public League update(long id, League obj){
        League newObj = findById(id);
        newObj.setLeagueName(obj.getLeagueName());
        newObj.setCountryName(obj.getCountryName());
        return repository.save(newObj);
    }

    public void delete(long id){
        var search = repository.findById(id);
        if(search.isPresent()){
            repository.delete(search.get());
        }
    }

    public List<League> findByName(String leagueName){
        return repository.findByLeagueNameContainsIgnoreCaseOrderByLeagueName(leagueName);
    }
}