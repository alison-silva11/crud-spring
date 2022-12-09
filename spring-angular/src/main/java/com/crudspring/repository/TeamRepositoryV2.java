package com.crudspring.repository;

import com.crudspring.model.TeamV2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepositoryV2 extends JpaRepository<TeamV2, Long> {
    public Optional<TeamV2> findById(long id);

    List<TeamV2> findByTeamNameContainsIgnoreCaseOrderByTeamName(String name);

    Page<TeamV2> findAll(Pageable pageable);

    List<TeamV2> findAll();
}