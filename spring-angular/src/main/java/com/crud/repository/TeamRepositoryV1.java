package com.crud.repository;

import com.crud.model.TeamV1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepositoryV1  extends JpaRepository<TeamV1, Long> {
    List<TeamV1> findByTeamNameContainsIgnoreCaseOrderByTeamName(String teamName);
}
