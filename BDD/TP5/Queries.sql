# 01
select max(prix)
from Catalogue;

# 02
select anom, count(acoul) as couleurs_dispo
from Articles
group by anom
order by anom;

# 03
select acoul, count(aid) as articles_dispo
from Articles
group by acoul
order by acoul;

# 04
select Articles.acoul, avg(prix) AS prix_moyen
from Articles
	inner join Catalogue
	on Articles.aid = Catalogue.aid
group by Articles.acoul
order by prix_moyen DESC;

# 05
select acoul, avg(prix) as prix_moyen
from Catalogue
inner join Articles
on Articles.aid = Catalogue.aid
where Articles.acoul in (	select acoul
							from (	select a1.aid, a1.acoul 
								from Articles as a1, Articles as a2
								where a1.aid <> a2.aid
								and a1.aid <> 11
								and a2.aid <>11
								and a1.acoul = a2.acoul) as FOO
						inner join (select distinct aid from Catalogue ) as BAR
						on FOO.aid = BAR.aid)
group by acoul
having count(Articles.aid) > 1
order by prix_moyen DESC;

# 06
select anom, count(fid) as nombre_fournisseurs
from Catalogue
inner join Articles
on Catalogue.aid = Articles.aid
group by anom
order by nombre_fournisseurs DESC;

# 07
select anom, acoul, count(fid) as nombre_fournisseurs
from Articles
inner join Catalogue
on Articles.aid = Catalogue.aid
group by anom, acoul
order by anom;

# 08
select Articles.anom, Catalogue.prix
from Catalogue
inner join Articles
on Articles.aid = Catalogue.aid
where prix = (	select max(prix) as max_prix
				from Catalogue);

# 09							
select Fournisseurs.fnom, Catalogue.prix
from Catalogue
inner join Fournisseurs
on Fournisseurs.fid = Catalogue.fid
where prix = (	select max(prix) as max_prix
				from Catalogue);				

# 10				
select fnom, count(aid)
from Fournisseurs
inner join Catalogue
on Fournisseurs.fid = Catalogue.fid
group by Fournisseurs.fid
having count(aid)>1;				
				
# 11			
select acoul
from Articles
group by acoul
having count(aid) = 1;				
				
# 12 
select aid
from Catalogue
group by aid
having count(fid)>1
order by aid;				
			
# 13
select distinct c1.fid
from Catalogue as c1, Catalogue as c2
where c1.fid = c2.fid
and (c1.aid, c2.aid) in (	select a1.aid, a2.aid
							from Articles as a1, Articles as a2
							where a1.anom = a2.anom
							and a1.acoul <> a2.acoul);
				
# 14
select distinct fnom, anom
from (	select c1.fid,c1.aid
		from Catalogue as c1, Catalogue as c2
		where c1.fid = c2.fid
		and (c1.aid, c2.aid) in (	select a1.aid, a2.aid
									from Articles as a1, Articles as a2
									where a1.anom = a2.anom
									and a1.acoul <> a2.acoul)) as FOO
inner join Fournisseurs
on FOO.fid = Fournisseurs.fid
inner join Articles
on FOO.aid = Articles.aid;
	
# 15
select anom, min(prix), max(prix)
from Articles
inner join Catalogue
on Catalogue.aid = Articles.aid
group by anom
having count(Catalogue.fid)>1;
	
# 16
select max(count)
from (	select count(aid) as count
		from Catalogue
		group by fid) as FOO;

# 17
select fnom
from Catalogue
inner join Fournisseurs
on Catalogue.fid = Fournisseurs.fid
group by fnom
having count(aid) = (	select max(count)
						from (	select count(aid) as count
								from Catalogue
								group by fid) as FOO);
				
# 18
select anom
from Articles
inner join Catalogue
on Articles.aid = Catalogue.aid
group by anom
having count(fid)=1;			
				
#19

select count(distinct anom)
from Articles
left join Catalogue
on Articles.aid = Catalogue.aid
where Catalogue.aid isNULL
group by anom;

# 20
select count(distinct anom)
from Articles
where aid not in (	select aid
					from Articles
					intersect
					select aid from catalogue)
group by anom;



#8 FAUX
select Articles.anom, max(Catalogue.prix)
from Articles, Catalogue
where Articles.aid = Catalogue.aid
group by Articles.anom;




# monopole
select anom, fnom
from Articles
inner join Catalogue
on Articles.aid = Catalogue.aid
inner join Fournisseurs
on Catalogue.fid = Fournisseurs.fid
where anom in (	select anom
				from Articles
				inner join Catalogue
				on Articles.aid = Catalogue.aid
				group by anom
				having count(fid)=1);		