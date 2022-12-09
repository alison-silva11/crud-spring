package com.crudspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "team")
@AllArgsConstructor
@NoArgsConstructor
public class TeamV1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(name = "team_name", nullable = false, length = 30)
    @Getter @Setter
    private String teamName;

    @Column(name = "create_year", nullable = false, length = 4)
    @Getter @Setter
    private String createYear;
}