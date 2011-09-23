set PROD;
param heures_ouvrees >= 0;
param vitesse_production {PROD} >= 0;
param prix_vente {PROD} >= 0;
param vente_max {PROD} >= 0;
param vente_min {PROD} >= 0;
var qte_produite {p in PROD} >= vente_min [p], <= vente_max [p];
maximize profit :
sum {p in PROD} qte_produite [p] * prix_vente [p];
subject to production_limitee :
sum {p in PROD} (qte_produite [p] / vitesse_production [p]) <= heures_ouvrees;
data;
set PROD := bandes rouleaux poutres;
param heures_ouvrees := 40;
param: vitesse_production prix_vente vente_max vente_min :=
bandes	200 rouleaux	140 poutres	160
25	6000	1000 30	4000	500 29	3500	750;
