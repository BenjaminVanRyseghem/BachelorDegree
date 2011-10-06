--TP3 - Benjamin Van Ryseghem

-----------------------------------------------------------

-- 1 - 	
		
		SELECT *	
		FROM Catalogue, Articles;
		
-- 2 - 	
		SELECT *
		FROM 	Catalogue 
				INNER JOIN Articles
				ON Articles.aid = Catalogue.aid ;
				
-- 3 - 	
			SELECT DISTINCT anom
		FROM 	Catalogue 
				INNER JOIN Articles
				ON Articles.aid = Catalogue.aid ;
				
-- 4 - 	
			SELECT anom, prix, fnom
		FROM 	(Catalogue 
				INNER JOIN Articles
				ON Articles.aid = Catalogue.aid) as TMP
					INNER JOIN Fournisseurs
					ON TMP.fid = Fournisseurs.fid;
					
-- 5 - 	
			SELECT DISTINCT anom
		FROM 	Catalogue 
				INNER JOIN Articles
				ON Articles.aid = Catalogue.aid
		WHERE prix < 20 ;
		
-- 6 - 	
		SELECT DISTINCT fnom
		FROM 	Catalogue 
				INNER JOIN Fournisseurs
				ON Fournisseurs.fid = Catalogue.fid
		WHERE prix < 20 ;
		
-- 7 - 	
		SELECT fnom
		FROM Fournisseurs
		WHERE fid	NOT IN (	SELECT Fournisseurs.fid
		 						FROM 	Fournisseurs
										LEFT OUTER JOIN Catalogue
										ON Fournisseurs.fid = Catalogue.fid
								WHERE prix < 20);
								
-- 8 - 	
		SELECT fnom
		FROM 	Fournisseurs
				INNER JOIN (	Catalogue
								INNER JOIN Articles
								ON Catalogue.aid = Articles.aid
				) AS TMP
				ON Fournisseurs.fid = TMP.fid
		WHERE acoul='vert';
		
		
-- 9 - 	
		SELECT DISTINCT Articles.aid
		FROM 	(Articles
				INNER JOIN (	Catalogue
								INNER JOIN Fournisseurs
								ON Fournisseurs.fid = Catalogue.fid
				) AS TMP
				ON Articles.aid = TMP.aid)
		WHERE ((acoul = 'rouge' OR acoul='magenta') AND prix < 25 );


-- 10 - 	
		SELECT DISTINCT Articles.aid
		FROM 	(Articles
				INNER JOIN (	Catalogue
								INNER JOIN Fournisseurs
								ON Fournisseurs.fid = Catalogue.fid
				) AS TMP
				ON Articles.aid = TMP.aid)
		WHERE (acoul = 'rouge' OR acoul='magenta' AND prix < 25 );

-- Le AND est prioritaire sur le OR, donc ici, on a (les articles rouge) ou (les articles qui sont magentas et dont le prix est inferieur a 25).
-- La verification sur le prix des articles rouges n'est pas effectuee.


-- 11 - 	
		SELECT fid
		FROM Fournisseurs
		WHERE fid NOT IN (	SELECT Fournisseurs.fid
							FROM 	Fournisseurs 
									INNER JOIN Catalogue
									ON Fournisseurs.fid = Catalogue.fid
							WHERE prix <= 10000 );
							

-- 12 - 	
		SELECT TMP1.aid AS aidvert, TMP2.aid AS aidrouge
		FROM (	SELECT aid
				FROM Articles
				WHERE acoul = 'vert') AS TMP1,
			 (	SELECT aid
				FROM Articles
				WHERE acoul = 'rouge') AS TMP2;
				
-- 13 - 	
		SELECT aid
		FROM Articles	
		EXCEPT (	SELECT aid
				FROM Articles
				INTERSECT	SELECT aid
							FROM Catalogue);
		
							
		SELECT Articles.aid
		FROM (	Articles
				LEFT OUTER JOIN Catalogue
				ON Articles.aid = Catalogue.aid)
		WHERE Catalogue.aid IS NULL;	
		
		SELECT aid
				FROM Articles
				WHERE aid NOT IN (	SELECT aid
									FROM Catalogue );

-- 14 - 	
		SELECT anom
		FROM Articles
		WHERE aid NOT IN (	SELECT aid
							FROM Catalogue );	
							
							
-- 15 - 	
		SELECT fid
		FROM Fournisseurs
		WHERE fid IN (	SELECT fid
						FROM 	Articles
								INNER JOIN Catalogue
								ON Articles.aid = Catalogue.aid
						WHERE acoul = 'vert'
						INTERSECT
						SELECT fid
						FROM 	Articles
								INNER JOIN Catalogue
								ON Articles.aid = Catalogue.aid
						WHERE acoul ='rouge');	
						
-- 16 - 	
		SELECT fnom
		FROM Fournisseurs
		WHERE fid IN (	SELECT fid
						FROM 	Articles
								INNER JOIN Catalogue
								ON Articles.aid = Catalogue.aid
						WHERE acoul = 'noir');		
						
-- 17 - 	
		SELECT DISTINCT c1.aid 
		FROM Catalogue AS c1, Catalogue AS c2
		WHERE c1.aid = c2.aid AND c1.fid <> c2.fid;
		
		
-- 18 - 	
		SELECT fnom
		FROM Fournisseurs
		WHERE fid NOT IN (	SELECT fid
						FROM 	Articles
								INNER JOIN Catalogue
								ON Articles.aid = Catalogue.aid
						WHERE acoul = 'noir'		
						OR acoul = 'argente');
		
		
		
		
		
		
		
		