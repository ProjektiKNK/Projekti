drop database spms;
create database spms;
use spms;

create table fakultetet(
	fid int auto_increment primary key,
	femri varchar(100) not null unique,
    fkapaciteti int
);

create table drejtimet(
	did int auto_increment primary key,
	demri varchar(100) not null,
    dfakulteti int not null,
    foreign key(dfakulteti) references fakultetet(fid),
    unique (demri,dfakulteti) 
);

create table shtetet(
	shid int auto_increment primary key,
	shemri varchar(100) not null
);
create table qytetet(
	qid int auto_increment primary key,
	qemri varchar(100) not null,
    qshteti int not null,
	foreign key(qshteti) references shtetet(shid),
    unique (qemri,qshteti) 
);

create table studentet(
	sid int auto_increment primary key,
    semri varchar(40) not null,
    smbiemri varchar(40) not null,
    sprindi varchar(40) not null,
    snrpersonal char(10) not null unique,
    sditelindja date not null,
    sshteti int not null,
    sqyteti int not null,
    sadresa varchar(100) not null,
    stel char(12),
    semail varchar(100) not null,
    sgjinia enum('M','F') not null,
    sfakulteti int not null,
    sdrejtimi int not null,
    sstatusi bool not null,
    sniveli bool not null,
    ssemestri int not null,
    sfoto varchar(200),
    foreign key(sshteti) references shtetet(shid),
    foreign key(sqyteti) references qytetet(qid),
    foreign key(sfakulteti) references fakultetet(fid),
    foreign key(sdrejtimi) references drejtimet(did)
);

create table fletpagesat(
	flid int auto_increment primary key,
    fstudenti int not null,
	flloji varchar(100) not null,
    fdata date not null,
    fpaguar enum('PO','JO') not null,
    fperdorur bool default 0 not null,
	foreign key(fstudenti) references studentet(sid)
    on delete cascade
);
ALTER TABLE studentet AUTO_INCREMENT = 11800000;



create table perdoruesit(
	pid int primary key,
    pemail varchar(100) not null,
	pfjalekalimi varchar(200) not null,
    psalt varchar(200),
    ptipi enum('s','p','a','r') not null
);
DELIMITER $$
create trigger shtoPerdoruesS after insert on studentet
for each row
begin
	insert into perdoruesit values(new.sid,new.semail, new.sid, '','s');
    end $$