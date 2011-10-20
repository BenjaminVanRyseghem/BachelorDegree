begin transaction;
	select nom, prix from machine;
commit;

begin transaction;
	select nom,ville from fournisseur 
		where fid in (select fid from piece where nom ='roue');
commit;

begin transaction;
	select p.nom,c.quantite from piece as p
	inner join composition as c
	on p.pid = c.pid 
	where c.mid in(select mid from machine where nom = 'Presse');
commit;

begin transaction;
	select sum(c.quantite) as quantite_composant
	from composition as c 
	where c.mid in (select mid from machine where nom = 'Presse');
commit;

begin transaction;
	select piece.nom 
	from piece
	inner join
	(	select * 
		from composition AS c
		where c.mid in (select mid from machine where nom = 'Presse')) AS FOO
	on piece.pid = FOO.pid
	intersect
	select piece.nom 
	from piece
	inner join
	(	select * 
		from composition AS c
		where c.mid in (select mid from machine where nom = 'Moissonneuse-batteuse')) AS FOO
	on piece.pid = FOO.pid;
commit;
begin transaction;
select piece.nom, FOO.quantite, f.nom, f.ville
from (piece
inner join
(	select * 
	from composition AS c
	where c.mid in (select mid from machine where nom = 'Moissonneuse-batteuse')) AS FOO
on piece.pid = FOO.pid)
left join fournisseur as f
on f.fid = piece.fid;

commit;

begin transaction;
select machine.nom, FOO.Quantities
from machine
inner join (select mid, sum(quantite) as Quantities
				from commande
				where dateliv <= '2009-04-30'
				group by commande.mid) as FOO
on FOO.mid=machine.mid;

commit;
