use SM;

insert into shtetet(shemri) values
('Kosovë'),
('Shqipëri'),
('Maqedoni'),
('Mali i Zi'),
('Kroaci');

insert into qytetet(qemri,qshteti) values
('Podujevë',1),
('Prishtinë',1),
('Gjilan',1),
('Vushtrri',1),
('Ferizaj',1),
('Skenderaj',1),
('Gjakovë',1),
('Prizren',1),
('Mitrovicë',1),
('Istog',1),
('Pejë',1),
('Kaçanik',1),
('Klinë',1),
('Shtime',1),
('Durrës',2),
('Tiranë',2),
('Krujë',2),
('Lezhë',2),
('Vlorë',2),
('Kukës',2),
('Ohër',3),
('Shkup',3),
('Budva',4),
('Podgorica',4),
('Dubrovnik',5),
('Split',5),
('Zagrep',5);

insert into fakultetet(femri,fkapaciteti) values
('FIEK',1000);

insert into drejtimet(demri,dfakulteti) values 
('Inxhinieri Kompjuterike',1),
('Elektroenergjetikë',1),
('Automatikë',1),
('Elektronikë',1),
('Telekomunikacion',1);

insert into perdoruesit(pid,pemail,pfjalekalimi,psalt,ptipi) values
(50001,'lindaimmeri@gmail.com', '024e796ffa5eefcfc17943d2bd1e175870935fff','aRasc32','r'),
(50002, 'gresasalihu@gmail.com','4018f65b508c04301448ec4f33de68eb3930cc62','byZeEK3','r');


insert into studentet(semri,smbiemri,sprindi, snrpersonal, sditelindja,sshteti,sqyteti,sadresa,stel,semail,sgjinia,
sfakulteti,sdrejtimi,sstatusi,sniveli,ssemestri,sfoto) values
('Gresa','Salihu','Besim','1244761012','1998-06-30',(select shid from shtetet where shemri='Kosovë'),4,'10 Maji','+38349145123','gresasalihuuu@gmail.com','M',1,1,1,0,1,''),
('Linda','Imeri','Avdush','1422760117','1998-3-3',(select shid from shtetet where shemri='Kosovë'),2,'Rruga A','+38344545342','lindaimeri@gmail.com','M',1,1,1,0,1,''),
('Leonita','Nika','Adem','1244760191','1998-12-02',(select shid from shtetet where shemri='Kosovë'),1,'Mejtin Imeri','+38344568439','leonita.nika@gmail.com','M',1,1,1,0,1,''),
('Ilirjana','Qelaj','Haki','1244671019','1998-01-24',(select shid from shtetet where shemri='Kosovë'),5,'Arif Aliu','+38345659956','ilirjanaqelaj@gmail.com','M',1,1,1,0,1,''),
('Jetlira','Fetahaj','Vehbi','1244181923','1998-07-09',(select shid from shtetet where shemri='Kosovë'),6,'Drenica','+38343847490','jetlirafetahaj@hotmail.com','M',1,1,1,0,1,''),
('Mergim','Grajqevci','Haki','1423182018','1998-01-01',(select shid from shtetet where shemri='Kosovë'),2,'Rruga B','+38344593902','mergimgrajqevci@outlook.com','M',1,1,1,0,1,''),
('Lea','Kastrati','Adem','1423182017','1998-01-01',(select shid from shtetet where shemri='Kosovë'),13,'Gjermani','+38345290193','leakastrati@gmail.com','M',1,1,1,0,1,''),
('Jeta','Jashari','Sinan','1423242518','1998-06-29',(select shid from shtetet where shemri='Kosovë'),2,'Adem Ramadani','+38344523049','jetajashari@gmail.com','M',1,1,1,0,1,''),
('Era','Krasniqi','Bajrush','1244171812','1998-01-29',(select shid from shtetet where shemri='Kosovë'),2,'Patriotet','+38344593019','erakrasniqi@gmail.com','F',1,1,1,0,1,''),
('Jehona','Thaci','Halil','1223241517','1998-08-21',(select shid from shtetet where shemri='Kosovë'),6,'Adem Jashari','+38345523149','jehonathaci@gmail.com','F',1,1,1,0,1,''),
('Diellza','Selimi','Musli','1223443518','1998-09-29',(select shid from shtetet where shemri='Kosovë'),2,'Veterniku','+38349523049','diellzaselimi@gmail.com','F',1,1,1,0,1,''),
('Njomza','Berisha','Banush','1123248518','1998-02-21',(select shid from shtetet where shemri='Kosovë'),9,'Ismajl Qemajli','+38345523129','njomzaberisha@live.com','F',1,1,1,0,1,''),
('Jeton','Avdyli','Fahrush','1423142324','1997-12-29',(select shid from shtetet where shemri='Kosovë'),5,'Ahmet Kaçiku','+38349523141','jetonavdyli@gmail.com','F',1,1,1,0,1,''),
('Klea','Sadiku','Hysen','1223252517','1998-02-19',(select shid from shtetet where shemri='Kosovë'),5,'Driton Islami','+38345513042','kleasadiku@gmail.com','F',1,1,1,0,1,''),
('Dafina','Ahmeti','Mejdi','1323546516','1998-05-22',(select shid from shtetet where shemri='Kosovë'),5,'Varoshi','+38344523049','dafinaahmeti@gmail.com','F',1,1,1,0,1,''),
('Bleona','Spanca','Agim','1323142618','1997-03-28',(select shid from shtetet where shemri='Kosovë'),5,'Bekim Restelica','+38345521149','bleonaspaca@gmail.com','F',1,1,1,0,1,''),
('Ledion','Neziri','Kemajl','1423212112','1998-08-29',(select shid from shtetet where shemri='Kosovë'),5,'Agim Aliu','+38344721048','ledionneziri@gmail.com','M',1,1,1,0,1,''),
('Dorontin','Ismaili','Muhamet','1226321311','1998-07-20',(select shid from shtetet where shemri='Kosovë'),12,'Hasan Prishtina','+38345711023','doronntinn@gmail.com','M',1,1,1,0,1,''),
('Klea','Gashi','Sabit','1254271316','1998-06-10',(select shid from shtetet where shemri='Kosovë'),3,'Nuhi Berish','+38349516023','kleaa_gashi19@live.com','F',1,1,1,0,1,''),
('Fiona','Spanca','Ismet','1236721323','1998-12-31',(select shid from shtetet where shemri='Kosovë'),4,'Kadri Zeka','+38349711027','fionaspanca@gmail.com','F',1,1,1,0,1,''),
('Jeton','Ahmeti','Arsim','1257322336','1998-07-20',(select shid from shtetet where shemri='Kosovë'),14,'Shtime','+38345712078','jahmeti1@gmail.com','F',1,1,1,0,1,''),
('Diellza','Krasniqi','Bajram','1234371329','1998-11-28',(select shid from shtetet where shemri='Kosovë'),1,'Arsim Gërxhaliu','+38349718021','dzkrasniqi@gmail.com','M',1,1,1,0,1,''),
('Arsim','Berisha','Ramush','1244376327','1996-01-01',(select shid from shtetet where shemri='Kosovë'),8,'Lidhja','+38344712031','arsim_bb1@hotmail.com','M',1,1,1,0,1,''),
('Jeta','Hoti','Bekim','1244161338','1998-06-26',(select shid from shtetet where shemri='Kosovë'),7,'Qarshia Jonë','+38345728067','jetahoti@gmail.com','M',1,1,1,0,1,''),
('Diellona','Kelmendi','Bilall','1244376149','1998-04-11',(select shid from shtetet where shemri='Kosovë'),11,'Ismet Peja','+38344718127','diellona_kelmendi18@gmail.com','M',1,1,1,0,1,''),
('Adem','Salihu','Agron','1234571612','1998-10-22',(select shid from shtetet where shemri='Kosovë'),4,'Haki Nuha','+38349516090','ademsalihu@gmail.com','F',1,1,1,0,1,''),
('Kosovare','Hyseni','Blerim','1254372336','1998-06-01',(select shid from shtetet where shemri='Kosovë'),10,'Bali Shatri','+38344716028','kosovareh@gmail.com','F',1,1,1,0,1,'');


insert into fletpagesat(fstudenti,flloji,fdata,fpaguar) values
(11800000,'Semester','2018-11-05','PO'),
(11800001,'Semester','2018-11-13','JO'),
(11800002,'Semester','2018-12-03','JO'),
(11800003,'Semester','2018-10-17','PO'),
(11800004,'Semester','2018-12-19','PO'),
(11800005,'Semester','2018-11-27','PO'),
(11800006,'Semester','2018-10-18','JO'),
(11800007,'Semester','2018-11-03','PO'),
(11800008,'Semester','2018-11-13','JO'),
(11800009,'Semester','2018-12-01','JO'),
(11800010,'Semester','2018-10-16','JO'),
(11800011,'Semester','2018-12-29','PO'),
(11800012,'Semester','2018-11-18','PO'),
(11800013,'Semester','2018-10-02','JO'),
(11800014,'Semester','2018-11-04','PO'),
(11800015,'Semester','2018-11-09','JO'),
(11800016,'Semester','2018-12-17','JO'),
(11800017,'Semester','2018-10-03','PO'),
(11800018,'Semester','2018-12-12','JO'),
(11800019,'Semester','2018-11-11','PO'),
(11800020,'Semester','2018-10-18','PO'),
(11800021,'Semester','2018-11-22','JO'),
(11800022,'Semester','2018-12-21','JO'),
(11800023,'Semester','2018-10-26','PO'),
(11800024,'Semester','2018-12-30','PO'),
(11800025,'Semester','2018-11-22','JO'),
(11800026,'Semester','2018-11-07','PO');