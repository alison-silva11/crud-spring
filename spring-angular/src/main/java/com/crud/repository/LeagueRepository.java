package com.crud.repository;


import com.crud.model.League;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeagueRepository extends JpaRepository<League, Long> {

    List<League> findByLeagueNameContainsIgnoreCase(String leagueName);

    List<League> findByLeagueNameContainsIgnoreCaseOrderByLeagueName(String leagueName);
}
