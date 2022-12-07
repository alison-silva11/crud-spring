alter table team add column team_awards varchar (30);
alter table team add column team_nickname varchar (30);
alter table team add column team_city varchar(30);
alter table team add column league_id int;
alter table team add constraint fk_team_league foreign key (league_id) references league(id);