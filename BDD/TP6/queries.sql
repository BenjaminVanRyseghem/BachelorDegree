-- 01

select aid
from Articles as a
where not exists (	select *
					from Catalogue as c
					where a.aid = c.aid);
					
-- 02

select fid 
from Fournisseur as f
where not exists (	select *
					from Catalogue as c
					where f.fid = c.fid);
					
-- 03

select acoul
from Articles as a
where not exists (	select *
					from Catalogue as c
					where a.aid = c.aid);
					
-- 04

select fid
from Catalogue as c
where not exists (	select *
					from Fournisseur as f
					c.fid = f.fid);

-- 05

select aid
from Catalogue as c
where not exists (	select *
					from Articles as a
					where c.aid = a.aid);
					
-- 06

select aid
from Articles
where exists ( 	select *
				from Catalogue
				where Articles.aid = Catalogue.aid
				and prix >= 100);

-- 07

select anom
from Articles
where exists ( 	select *
				from Catalogue
				where Articles.aid = Catalogue.aid
				and fid in (select fid from Fournisseurs where fnom = 'kiventout'));
				
-- 08

select aid
from Articles
where exists ( 	select distinct *
				from Catalogue as c1
				where exists ( 	select *
								from Catalogue as c2
								where c1.aid = c2.aid
								and c1.fid <> c2.fid )
				and Articles.aid = c1.aid);
				
-- ou alors la requete suivante, mais l'ordre est different

select distinct aid
from Catalogue as c1
where exists ( 	select *
				from Catalogue as c2
				where c1.aid = c2.aid
				and c1.fid <> c2.fid );				

-- 09

select distinct anom
from Articles as a1
where exists (	select *
				from Articles as a2
				where a1.anom = a2.anom
				and a1.acoul <> a2.acoul);
				
-- 10

select distinct aid
from Articles as a1
where not exists (	select *
					from Articles as a2
					where a1.anom = a2.anom
					and a2.acoul = 'vert')
and a1.acoul = 'rouge';

-- 11

select distinct anom
from Articles as a1
where not exists (	select *
					from Articles as a2
					where a1.anom = a2.anom
					and a2.acoul <> 'rouge')
and a1.acoul = 'rouge';

-- 12

select distinct c.aid 
from Catalogue c 
where exists (	select *
				from fournisseurs f
      			where f.fid=c.fid
				and  fad like '%USA')
and not exists (	select *
					from Catalogue c2
					where c.aid = c2.aid
					and exists (	select *
										from fournisseurs f
					      				where f.fid=c2.fid
										and  fad not like '%USA'));
										
										
-- 13

select fid
from Fournisseurs f1
where exists (	select * 
				from Catalogue
				where f1.fid = Catalogue.fid
				and exists (	select * 
								from Articles
								where Catalogue.aid = Articles.aid
								and Articles.acoul = 'vert'))
and exists (	select *
				from Fournisseurs f2
				where f1.fid = f2.fid
				and exists (	select * 
								from Catalogue
								where f2.fid = Catalogue.fid
								and exists (	select * 
												from Articles
												where Catalogue.aid = Articles.aid
												and Articles.acoul = 'rouge')));

-- 14
								
select fid
from Fournisseurs f
where not exists (
				select distinct fid
				from Fournisseurs, (	select aid 
									from Articles) as Foo
				where Fournisseurs.fid = f.fid
				and not exists ( 		select fid, aid
										from Catalogue c2
										where Fournisseurs.fid = c2.fid
										and Foo.aid = c2.aid));
										
-- 15 

select fid
from Fournisseurs f
where not exists (
				select distinct fid
				from Fournisseurs, (	select aid 
										from Articles
										where acoul = 'rouge') as Foo
				where Fournisseurs.fid = f.fid
				and not exists ( 		select fid, aid
										from Catalogue c2
										where Fournisseurs.fid = c2.fid
										and Foo.aid = c2.aid));
										
-- 16
select distinct fid, aid
from Catalogue c1
where not exists ( 	select *
					from Catalogue c2
					where c1.aid = c2.aid
					and c1.fid <>c2.fid);