create table team(
    id serial not null,
    team_name varchar (30),
    create_year varchar(4),
    constraint pk_idteam primary key(id)
)