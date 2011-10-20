#define MAXLINE 81
/* Lit une ligne sur l’entree standard. Cette ligne doit comporter moins de MAXLINE caracteres.
Le resultat est retourne dans line. Un \0 est ecrit en fin de la chaine.
Le tableau line doit etre de taille au moins MAXLINE+1.
Retourne le nombre de caracteres lu, non compris le \0 final. Retourne EOF si la fin de fichier est atteinte.
Termine le programme sur une erreur si rencontre une ligne de plus de MAXLINE caracteres.
*/
extern int readl(char line[]);
extern void error(char* errorMessage);
