drop database if exists zavrsnijp21;
create database zavrsnijp21 default character set utf8;
use zavrsnijp21;

create table participant(
    id int not null primary key auto_increment,
    name varchar(50) not null,
    surname varchar(50) not null,
    email varchar(50) not null
);

create table site(
    id int not null primary key auto_increment,
    site_name varchar(100) not null,
    site_code varchar(50),
    region varchar(50),
    latitude decimal(9,6),
    longitude decimal(9,6)
);

create table bird_count(
    id int not null primary key auto_increment,
    date datetime not null,
    coverage varchar(50),
    quality varchar(50),
    method varchar(50),
    water varchar(50),
    ice varchar(50),
    tidal varchar(50),
    weather varchar(50),
    disturbed varchar(50),
    site int not null,
    participant int not null
);

create table species(
    id int not null primary key auto_increment,
    scientific_name_genus varchar(50) not null,
    scientific_name_species varchar(50) not null,
    english_name varchar(50),
    species_group varchar(50),
    species_code varchar(50)
);

create table species_bird_count(
    species int not null,
    bird_count int not null,
    number_of_bird int not null
);

alter table bird_count add foreign key (site) references site(id);
alter table bird_count add foreign key (participant) references participant(id);

alter table species_bird_count add foreign key (species) references species(id);
alter table species_bird_count add foreign key (bird_count) references bird_count(id);