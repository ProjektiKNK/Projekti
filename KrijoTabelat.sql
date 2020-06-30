create table perdoruesit1 (
    pid int(10) not null,
pemail varchar(255) not null unique,
pfjalekalimi varchar(20) not null,
psalt varchar(255),
ptipi varchar(1) not null
);

create table studentet1 (
    sid int not null,
    semri varchar(100),
    smbiemri varchar(100),
    sprindi varchar(100),
    snrpersonal varchar(100),
sditelindja varchar(100),
    sshteti varchar(100),
    sqyteti varchar(100),
    sadresa varchar(100),
    stel varchar(100),
    semail varchar(100),
    sgjinia varchar(100),
sfakulteti varchar(100),
    sdrejtimi varchar(100),
    sstatusi varchar(100),
    sniveli varchar(100),
    ssemestri varchar(100),
    sfoto varchar(100) );