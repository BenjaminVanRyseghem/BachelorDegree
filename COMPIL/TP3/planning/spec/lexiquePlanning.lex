/*****************************************************
 * Analyseur lexical pour Init version simple
 * fichier de description pour JFlex
 * produit anLexInit/ScannerInit.java
 * M. Lepan & M. Van Ryseghem 
 * 2011/10/05
 ****************************************************/

/***********************************************************************
 * Première partie : code utilisateur inclus tel quel dans le fichier
 * .java généré. On met typiquement ici les déclarations de paquetage
 * (package) et les importations de classes (import).
 ***********************************************************************/

// déclaration du paquetage auquel appartient la classe générée
package planningMaster.analyseurs;
%%

/***********************************************************************
 * Seconde partie : options et déclarations de macros. 
 ***********************************************************************/

/*************************   Options  **********************/ 

// ATTENTION : le % doit toujours être en 1ère colonne

// la classe générée implantant l'analyseur s'appelle ScannerInit.java
%class ScannerPlanning
// et est publique
%public
// la cl. générée implante l'itf java_cup.runtime.Scanner fournie par Cup
%implements java_cup.runtime.Scanner
// pour utiliser les caractères unicode
%unicode
//definitions des etats
%state A
%state B
%state C
// pour garder trace du numéro de ligne du caractère traité
%line
// pour garder trace du numéro de colonne du caractère traité
%column
// l'an. lex. retourne des symboles de type java_cup.runtime.Symbol
%type java_cup.runtime.Symbol
// la fonction de l'analyseur fournissant le prochain Symbol s'appelle
// next_token...
%function next_token
// ... et lève une exception ScannerException en cas d'erreur lexicale
%yylexthrow{
ScannerException
%yylexthrow}
// action effectuée qd la fin du fichier à analyser est rencontrée
// le type EOF est généré automatiquement par Cup
%eofval{
  return new Symbole(TypeSymboles.EOF);
%eofval}
// code recopié dans la classe générée
%{
  private Symbole creerSymbole(String representation, int type) {
    return new Symbole(representation,type,yyline,yycolumn);
  }

  private Symbole creerSymbole(String representation, int type, Object valeur) {
    return new Symbole(representation,type,valeur,yyline,yycolumn);
  }  
%}

/*************************   définitions macros  **********************/ 

// une macro est une abbréviation pour une expression régulière

// syntaxe : <nom_macro> = <expr_reg>
// une macro peut être utilisée pour en définir une autre (de
// manière non récursive !) : il faut alors entourer son
// identificateur d'accolades.

endOfLine = \r|\n|\r\n // convention Java
// | est le choix des expr reg de JFlex
// \n = retour-chariot sous Unix, \r = rc sous Windows

blancs = {endOfLine} | [ \t\f] 
// \t = tabulation, \f = form-feed
// [ \t\f] est une classe de caractères qui dénote soit " ", soit \t,
// soit \f  



word = [A-Za-z0-9]+
capitalizedWord = [A-Z][A-Za-z]+
room = [A-Z][a-zA-Z0-9]+

day = (((1|2)?)[:digit:])|30|31
month = {word}
year = 20[:digit:][:digit:]
date = {day}{blancs}*{month}{blancs}*{year}

hour = 1?[:digit:]|20|21|22|23|24
minutes = [0-5][:digit:]|60
hourAndMinutes = {hour}"h"{minutes}
slot = {hourAndMinutes}"-"{hourAndMinutes}

name = ({capitalizedWord} ({blancs}*{capitalizedWord})+)?
entreprise = ({word} ({blancs}*{word})*)?


options = ({word}({word}| [ \t\f] | "," | "-" | ";" )*)?

master = ("IAGL"|"TIIR"|"eServices"|"IVI")


dateCst = "date"
masterCst = "master"
roomCst = "salle"
smallPauseCst = "petitePause"
bigPauseCst = "grandePause"
%%

/***********************************************************************/
/* Troisième partie : règles lexicales et actions. */
/***********************************************************************/

// syntaxe : { <nom_macro> | <expr_reg> } { <code_java> } un return ds
// le code Java correspond au retour d'un symbole (ici de type Symbol)
// résultat de la méthode d'analyse (ici la fonction next_token). 
// S'il n'y a pas de return, on passe au symbole suivant.
{blancs} { /* on ne fait rien */ }
{dateCst} { // on a reconnu le mot-clé program
  return creerSymbole("date",TypeSymboles.DATECST);
}
{masterCst} { // on a reconnu le mot-clé int
  return creerSymbole("master",TypeSymboles.MASTERCST);
}
{roomCst} {// on a reconnu un read
  return creerSymbole("room",TypeSymboles.ROOMCST);
}

{smallPauseCst} {// on a reconnu un read
  return creerSymbole("petitePause",TypeSymboles.PETITEPAUSE);
}

{bigPauseCst} {// on a reconnu un read
  return creerSymbole("grandePause",TypeSymboles.GRANDEPAUSE);
}

// on a défini tous les mot-clés qui pourraient préfixer un indentificateur :
// on définit donc maintenant seulement les identificateurs

{master} {
	yybegin(YYINITIAL);
  	return creerSymbole("MASTER",TypeSymboles.MASTER,yytext());
}
<YYINITIAL>
{room} {
  return creerSymbole("ROOM",TypeSymboles.ROOM,yytext());
}

{slot} {
	yybegin(A);
  	return creerSymbole("SLOT", TypeSymboles.SLOT, yytext());
}

<A>
{name} {
	yybegin(B);
  	return creerSymbole("NAME",TypeSymboles.NAME,yytext());
}

<B>
{entreprise} {
	yybegin(C);
  	return creerSymbole("ENTREPRISE",TypeSymboles.ENTREPRISE,yytext());
}

<C>
{options} {// on a reconnu un opérateur d'affectation
	yybegin(YYINITIAL);
  	return creerSymbole("OPTIONS",TypeSymboles.OPTIONS, yytext());
}
<YYINITIAL>
{date} {
  return creerSymbole("DATE",TypeSymboles.DATE,yytext());
}

";" {// on a reconnu un ";"
	return creerSymbole("SEPARATOR",TypeSymboles.SEPARATOR);
}

.|\n {// erreur : .|\n désigne n'importe quel caractère non reconnu
      // par une des règles précédentes 
  throw new ScannerException("symbole inconnu, caractère " + yytext() + 
				 " ligne " + yyline + " colonne " + yycolumn);
}  