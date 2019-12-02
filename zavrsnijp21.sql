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

insert into participant(id,name,surname,email) values
(null,'Tibor','Mikuska','tmikuska@gmail.com'),
(null,'Adrian','Tomik','atomik@gmail.com'),
(null,'Josip','Ledinšćak','jledinscak@gmail.com'),
(null,'Maksima','Mijatović','mmijatovic@gmail.com');

insert into site(id,site_name,site_code,region,latitude,longitude) values
(null,'Donji Miholjac fishponds','HR00225','Danube watershed',45.767071,18.198162),
(null,'Topoljski Dunavac oxbow','HR00718','Danube watershed',45.862307,18.198162),
(null,'Suza village - fields','HR10000','Danube watershed',45.774041,18.782845),
(null,'Nasicka Breznica fishponds','HR00237','Danube watershed',45.56929,18.172459),
(null,'Nijemci village','HR10000','Sava watershed',45.140546,19.034328),
(null,'Danube river-6 (1341-1350 rkm Borovo)','HR00259','Danube watershed',45.426271,19.020424);

insert into bird_count(id,date,coverage,quality,method,water,ice,tidal,weather,disturbed,site,participant) values
(null,'2017-01-15','Excellent=76-100%','real count','Survey on foot or vehicle,Telescope used','Normal(wet)','Partly frozen < 90%','No tides','No effect','No effect',1,1),
(null,'2019-01-29','Excellent=76-100%','real count','Survey on foot or vehicle,Telescope used','Normal(wet)','Complete frozen ','No tides','Little effect','No effect',2,2),
(null,'2016-01-14','Bad=<25%','real count','Survey on foot or vehicle,Telescope used','Normal(wet)','Not frozen','No tides','No effect','No effect',3,4),
(null,'2016-01-28','Excellent=76-100%','real count','Survey on foot or vehicle,Telescope used','Normal(wet)','Partly frozen < 90%','No tides','No effect','No effect',4,3),
(null,'2015-01-26','Unknown','real count','Survey on foot or vehicle','Normal(wet)','Not frozen','No tides','No effect','No effect',5,4),
(null,'2015-01-28','Bad=<25%','real count','Survey on foot or vehicle,Telescope used','Normal(wet)','Not frozen','No tides','No effect','No effect',6,2);

insert into species(id,scientific_name_genus,scientific_name_species,english_name,species_group,species_code) values
(null,'Ardea','cinerea','Grey Heron','Herons','ARDCI'),
(null,'Buteo','buteo','Eurasian Buzzard','Raptors','BUTBU'),
(null,'Falco','tinnunculus','Common Kestrel','Raptors','FALTI'),
(null,'Alcedo','atthis','Common Kingfisher','Miscellaneous','ALCAT'),
(null,'Asio','otus','Northern Long-eared Owl','Raptors','ASIOT'),
(null,'Fulica','atra','Common Coot','Rails and Coots','FULAT');

insert species_bird_count(species,bird_count,number_of_bird) values
(1,1,270),
(2,2,4),
(3,3,2),
(4,4,6),
(5,5,38),
(6,6,10);
