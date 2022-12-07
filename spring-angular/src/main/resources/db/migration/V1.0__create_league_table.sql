create table league(
    id serial,
    league_name varchar(30) not null,
    country_name varchar(30),
    constraint pk_league primary key(id)
)