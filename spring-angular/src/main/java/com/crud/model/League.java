package com.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "league")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;

    @Column(name = "league_name", nullable = false, length = 30)
    @Getter @Setter
    private String leagueName;

    @Column(name = "country_name", nullable = false, length = 30)
    @Getter @Setter
    private String countryName;

}
