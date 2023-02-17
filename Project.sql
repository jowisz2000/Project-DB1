--tabele

create table referee
(id_referee int, first_name varchar(20), last_name varchar(20), age int);
create table stadium
(stadium_name varchar(50), city varchar(30), capacity int);
create table match
(id_match int, score varchar(8), date varchar(20), stadium_name varchar(50), hosts_team varchar(50), away_team varchar(50));
create table match_referee
(id_match int, id_referee int);
create table team
(team_name varchar(50), foundation_year varchar(10));
create table sponsor
(sponsor_name varchar(30), support varchar(100));
create table sponsor_team
(sponsor_name varchar(30), team_name varchar(50), fee int);
create table player
(id_player int, team_name varchar(50), first_name varchar(20), last_name varchar(20), position varchar(20), age int);
create table goal
(id_goal int, id_match int, id_player int, minute int);
create table coach
(id_coach int, first_name varchar(20), last_name varchar(20), role varchar(50), team_name varchar(50));

-- klucze glowne

alter table referee add primary key (id_referee);
alter table stadium add primary key (stadium_name);
alter table match add primary key (id_match);
alter table team add primary key (team_name);
alter table sponsor add primary key (sponsor_name);
alter table coach add primary key (id_coach);
alter table player add primary key (id_player);
alter table goal add primary key (id_goal);

-- klucze obce

alter table match add foreign key(stadium_name) references stadium(stadium_name);
alter table match add foreign key(hosts_team) references team(team_name);
alter table match add foreign key(away_team) references team(team_name);
alter table match_referee add foreign key (id_referee) references referee(id_referee);
alter table match_referee add foreign key (id_match) references match(id_match);
alter table sponsor_team add foreign key (sponsor_name) references sponsor(sponsor_name);
alter table sponsor_team add foreign key (team_name) references team(team_name);
alter table coach add foreign key (team_name) references team(team_name);
alter table player add foreign key (team_name) references team(team_name);
alter table goal add foreign key (id_match) references match(id_match);
alter table goal add foreign key (id_player) references player(id_player);

-- dane

insert into referee values 
(1, 'Szymon', 'Marciniak', 41),
(2, 'Michael', 'Oliver', 36),
(3, 'Tomasz', 'Listkiewicz', 44),
(4, 'Tomasz', 'Frankowski', 49),
(5, 'Damian', 'Sylwestrzak', 31),
(6, 'Wojciech', 'Myć', 33),
(7, 'Clement', 'Turpin', 48),
(8, 'Daniele', 'Orsato', 39);

insert into stadium values
('Suzuki Arena', 'Kielce', 16000),
('Allianz Stadion', 'Szczecin', 25000),
('Arena Zabrze', 'Zabrze', 23000),
('Tarczyński Arena', 'Wrocław', 42000),
('Polsat Stadion', 'Gdańsk', 35000);

insert into team values
('Górnik Zabrze', 1948),
('Legia Warszawa', 1920),
('Zagłębie Lubin', 1935),
('Korona Kielce', 1973),
('Lech Poznań', 1921),
('Pogoń Szczecin', 1945);

insert into match values
(1, '1-2', '13-11-2022', 'Allianz Stadion', 'Górnik Zabrze', 'Pogoń Szczecin'),
(2, '2-1', '12-11-2022', 'Suzuki Arena', 'Korona Kielce', 'Lech Poznań'),
(3, '1-0', '15-11-2022', 'Arena Zabrze', 'Górnik Zabrze', 'Legia Warszawa'),
(4, '1-1', '10-11-2022', 'Allianz Stadion', 'Legia Warszawa', 'Korona Kielce'),
(5, '0-2', '17-11-2022', 'Polsat Stadion', 'Zagłębie Lubin', 'Lech Poznań'),
(6, '1-1', '11-11-2022', 'Arena Zabrze', 'Zagłębie Lubin', 'Pogoń Szczecin');

insert into sponsor values
('Betclic', 'logo na koszulkach'),
('Adidas', 'sponsor techniczny'),
('KFC', 'catering'),
('Kappa', 'sponsor techniczny'),
('STS', 'logo na koszulkach'),
('Stihl', 'logo na koszulkach'),
('Nike', 'sponsor techniczny');

insert into coach values
(1, 'Czesław', 'Michniewicz', 'Trener głowny', 'Górnik Zabrze'),
(2, 'Piotr', 'Tworek', 'Trener główny', 'Zagłębie Lubin'),
(3, 'Kosta', 'Runjaic', 'Trener główny', 'Legia Warszawa'),
(4, 'Waldemar', 'Fornalik', 'Trener główny', 'Korona Kielce'),
(5, 'John', 'van den Brom', 'Trener główny', 'Lech Poznań'),
(6, 'Jens', 'Gustafsson', 'Trener główny', 'Pogoń Szczecin'),
(7, 'Adam', 'Zazadzki', 'Analityk', 'Górnik Zabrze'),
(8, 'Marek', 'Papszun', 'Analityk', 'Zagłębie Lubin'),
(9, 'Adam', 'Zając', 'Analityk', 'Legia Warszawa'),
(10, 'Marek', 'Śledź', 'Trener od przygotowania fizycznego', 'Korona Kielce'),
(11, 'Arkadiusz', 'Mleczko', 'Trener od przygotowania fizycznego', 'Lech Poznań'),
(12, 'Boguław', 'Zapała', 'Trener od przygotowania fizycznego', 'Pogoń Szczecin'),
(13, 'Mirosław', 'Oksiński', 'Trener od przygotowania fizycznego', 'Legia Warszawa');

insert into player values
(1, 'Górnik Zabrze', 'Lukas', 'Podolski', 'Napastnik', 37),
(2, 'Górnik Zabrze', 'Robert', 'Dadok', 'Pomocnik', 28),
(3, 'Górnik Zabrze', 'Szymon', 'Włodarczyk', 'Napastnik', 19),
(4, 'Górnik Zabrze', 'Erik', 'Jensen', 'Obrońca', 30),
(5, 'Legia Warszawa', 'Josue', 'Pereira', 'Pomocnik', 32),
(6, 'Legia Warszawa', 'Bartosz', 'Kapustka', 'Pomocnik', 26),
(7, 'Legia Warszawa', 'Jose', 'Kante', 'Napastnik', 30),
(8, 'Zagłębie Lubin', 'Dominik', 'Hładun', 'Bramkarz', 27),
(9, 'Zagłębie Lubin', 'Dawid', 'Hanc', 'Pomocnik', 22),
(10, 'Korona Kielce', 'Adam', 'Frączak', 'Napastnik', 28),
(11, 'Korona Kielce', 'Karol', 'Angielski', 'Napastnik', 23),
(12, 'Korona Kielce', 'Wojciech', 'Łakomy', 'Obrońca', 35),
(13, 'Lech Poznań', 'Joao', 'Amaral', 'Pomocnik', 31),
(14, 'Lech Poznań', 'Mikael', 'Ishak', 'Napastnik', 29),
(15, 'Lech Poznań', 'Filip', 'Szymczak', 'Pomocnik', 20),
(16, 'Lech Poznań', 'Bartosz', 'Salamon', 'Obrońca', 26),
(17, 'Pogoń Szczecin', 'Igor', 'Łasicki', 'Napastnik', 29),
(18, 'Pogoń Szczecin', 'Jean', 'Carlos', 'Napastnik', 23),
(19, 'Pogoń Szczecin', 'Kacper', 'Kozłowski', 'Pomocnik', 18);

insert into match_referee values
(1,1),
(1,2),
(1,3),
(2,1),
(2,3),
(2,4),
(3,2),
(3,3),
(3,5),
(4,1),
(4,4),
(4,6),
(5,5),
(5,6),
(5,8),
(6,6),
(6,7),
(6,8);

-- sponsor, druzyna
insert into sponsor_team values
('Betclic', 'Górnik Zabrze', 20000),
('Betclic', 'Zagłębie Lubin', 20000),
('Adidas', 'Legia Warszawa', 15000),
('KFC', 'Pogoń Szczecin', 37000),
('Kappa', 'Pogoń Szczecin', 9000),
('STS', 'Legia Warszawa', 6800),
('STS', 'Zagłębie Lubin', 3000),
('STS', 'Korona Kielce', 6000),
('Stihl', 'Zagłębie Lubin', 2000),
('Stihl', 'Lech Poznań', 40000);

-- id_gola, mecz, zawodnik, minuta
insert into goal values
(1, 1, 1, 44),
(2, 1, 19, 68),
(3, 1, 18, 91),
(4, 2, 10, 1),
(5, 2, 11, 37),
(6, 2, 14, 47),
(7, 3, 3, 78),
(8, 4, 5, 23),
(9, 4, 12, 66),
(10, 5, 8, 33),
(11, 5, 9, 34),
(12, 6, 17, 17),
(13, 6, 8, 19);


create view sum_of_goals as
select count(*) as sum, team.team_name from team 
join player using (team_name)
join goal using (id_player)
join match using (id_match)
group by team.team_name;

create view amount_of_fee as
select sum(fee) as sum, team.team_name from team 
join sponsor_team using (team_name) 
join sponsor using (sponsor_name) 
group by team.team_name order by 2;

create view sum_of_refereed_matches as
select referee.first_name, referee.last_name, count(*) as sum from referee 
join match_referee using (id_referee)
join match using (id_match)
group by 1,2;