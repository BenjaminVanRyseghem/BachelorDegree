begin transaction; 
	create table machine(
	mid Integer,
	nom varchar(30),
	prix real,
	description varchar(60),
	primary key(mid));
commit;

begin transaction;
	create table commande(
	cid Integer,
	mid Integer,
	dateliv date,
	quantite integer,
	nomclient varchar(30),
	primary key(cid),
	foreign key(mid) references machine(mid));
commit;

begin transaction;
	create table fournisseur(
	fid Integer,
	nom varchar(30),
	ville varchar(30),
	adresse varchar(60),
	numtel integer check (numtel < 10000000000),
	numfax integer check (numfax < 10000000000),
	primary key(fid));
commit;

begin transaction;
	create table piece(
	pid Integer,
	fid integer,
	nom varchar(30),
	nbexempl integer,
	primary key(pid),
	foreign key(fid) references fournisseur(fid));
commit;

begin transaction;
	create table composition(
	mid Integer,
	pid integer,
	quantite integer,
	foreign key(mid) references machine(mid),
	foreign key(pid) references piece(pid));
commit;

begin transaction; 
	INSERT INTO machine VALUES (1,'Presse',35000);
	INSERT INTO machine VALUES (2,'Moissonneuse-batteuse',50000);
commit;

begin transaction; 
	INSERT INTO fournisseur VALUES (1,'Recharges Agricoles','Boulogne',null,0320885522,0320885511);
	INSERT INTO fournisseur VALUES (2,'MultiRoues','Tourcoing',null,0320774411,0320774422);
	INSERT INTO fournisseur VALUES (3,'Pouce Vert','Lille',null,0320998877,0320998844);
commit;


begin transaction; 
	INSERT INTO piece VALUES (1,2,'roue',100);
	INSERT INTO piece VALUES (2,1,'arbre',100);
	INSERT INTO piece VALUES (3,2,'deroulement',100);
	INSERT INTO piece VALUES (4,1,'embrayage',100);
	INSERT INTO piece VALUES (5,null,'structure primaire',100);
	INSERT INTO piece VALUES (6,null,'van',100);
	INSERT INTO piece VALUES (7,null,'batteur',100);
	INSERT INTO piece VALUES (8,3,'ascenseur',100);
commit;

begin transaction; 
	INSERT INTO composition VALUES (1,2,1);
	INSERT INTO composition VALUES (1,3,10);
	INSERT INTO composition VALUES (1,4,4);
	INSERT INTO composition VALUES (1,1,4);
	INSERT INTO composition VALUES (1,5,1);
	INSERT INTO composition VALUES (2,6,1);
	INSERT INTO composition VALUES (2,7,1);
	INSERT INTO composition VALUES (2,8,1);
	INSERT INTO composition VALUES (2,1,4);
	INSERT INTO composition VALUES (2,5,1);
commit;

begin transaction; 
	INSERT INTO commande VALUES (1,1,'2009-03-15',15,'Mecanique Lucien');
	INSERT INTO commande VALUES (2,1,'2009-03-30',50,'Saponnier');
	INSERT INTO commande VALUES (3,1,'2009-04-30',10,'Chicorée');
	INSERT INTO commande VALUES (4,2,'2009-04-30',30,'Chicorée');
	INSERT INTO commande VALUES (5,2,'2009-05-20',1,'Gremise');
commit;
