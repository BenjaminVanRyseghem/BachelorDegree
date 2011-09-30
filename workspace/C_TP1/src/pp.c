/*Lepan Francois Benjamin Van Ryseghem*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int indent = 0;
int previousCharacters[3];
char tab[4] = "    ";
int tabLength = 4;


void setCharacter(char c){
	previousCharacters[2] = previousCharacters[1];
	previousCharacters[1] = previousCharacters[0];
	previousCharacters[0] = c;
}


void indentText(){
	int i;
	for (i = 0; i<indent; i++)
	{
		printf("%s", tab);
	}

}

int main()
{
    int c, nbErreur = 0, accolade = 0, ligne = 0;

   
    enum {ETAT_DEBUT_LIGNE, ETAT_NORMAL, ETAT_COMMENTAIRE, ETAT_DEBUT_COMMENTAIRE, ETAT_GUILLEMET, ETAT_DIESE, ETAT_OPERATOR, ETAT_SIMPLE_QUOTE } etat = ETAT_DEBUT_LIGNE;



    /* plop
      plip
     ploup */

    while ((c=getchar()) != EOF) 
    {
ligne++;
switch (etat)
{
            case ETAT_DEBUT_LIGNE:
                switch (c) 
                {
                    case ' ': /*cas d'un espace*/
                  		break;
      
                    case '\t': /*cas d'une tabulation*/
                        break;

                  	case '\n': /*cas d'un retour a la ligne*/
        				setCharacter(c);
                  		break;
                  		
                    case ';' : /*cas d'un point virgule*/
                    	indentText();
                    	putchar(c);
                    	putchar('\n');
        				setCharacter(c);
						break;

                    case '/' : /*cas d'un slash*/
        				setCharacter(c);
        				break;
        				
                    case '#':
                    	setCharacter(c);
                    	putchar(c);
                    	etat = ETAT_DIESE;
                    	break;

                    case '*' : /*cas d'un début de commentaire*/
                    	if (previousCharacters[0] == '/')
                    	{
                    		putchar('\n');
                    		indentText();
		                	etat = ETAT_DEBUT_COMMENTAIRE;
		                	putchar(previousCharacters[0]);
		                	putchar(c);
		                }
        				setCharacter(c);
                    	break;
                    	
                    case '{' :  /*cas d'une acolade ouvrante*/
                    	if (previousCharacters[0] != '\n' && previousCharacters[0] != ';' && previousCharacters[0] != '}')

                    	putchar('\n');
                    	indentText();
                    	putchar(c);
                    	putchar('\n');
                    	indent++;
                    	accolade++;
        				setCharacter(c);
                    	break;
                   		
                   	case '}' : /*cas d'une accolade fermante*/
                   		if (previousCharacters[0] != '\n' && previousCharacters[0] != ';' && previousCharacters[0] != '}' )
                    		putchar('\n');

                   		indent--;

                   		indentText();
                    	putchar(c);
                    	putchar('\n');
                        
                    	accolade--;
        				setCharacter(c);
                    	break;

					case '\0': /*cas de fin de fichier*/
                    	break;
                    	
                   	default: /* sinon */
                   		indentText();
   						putchar(c);
   						
        				setCharacter(c);
                        etat = ETAT_NORMAL;
                        break;
                }
               	break;
               	
            case ETAT_NORMAL:
                switch (c) 
                {
                 	case '\n': /*cas d'un retour a la ligne*/
                        putchar(c);
                        etat = ETAT_DEBUT_LIGNE;

        				setCharacter(c);
                        break;
                    
                    case ';' : /*cas d'un point virgule*/
                    	putchar(c);
                    	putchar('\n');
                    	
                    	etat = ETAT_DEBUT_LIGNE;

        				setCharacter(c);
                    	break;
                    	
                	case '/' : /* cas d'un slash */

        				setCharacter(c);
        				break;
        				
                	case '*' : /*cas d'un début de commentaire*/
                    	if (previousCharacters[0] == '/')
                    	{
                    		if (previousCharacters[1] != '\n')
                    			putchar('\n');
                    		
                    		indentText();
		                	etat = ETAT_DEBUT_COMMENTAIRE;
		                	putchar(previousCharacters[0]);
		                	putchar(c);
		                }
		                
        				setCharacter(c);
                    	break;
					
                	case 'r': /* cas du for */
                		putchar(c);

                		if ((previousCharacters[0] == 'o') && (previousCharacters[1] == 'f')) etat = ETAT_OPERATOR;
						setCharacter(c);
                		break;

                	case 'f': /* cas du if */
                		putchar(c);

                		if (previousCharacters[0] == 'i') etat = ETAT_OPERATOR;
						setCharacter(c);
                		break;

					case '\'' : /* cas d'un simple quote */
						putchar(c);
	        			setCharacter(c);
						etat = ETAT_SIMPLE_QUOTE;
	                    break;

					case '"' : /* cas d'un guillemet ouvrant */
						putchar(c);
						setCharacter(c);
						etat = ETAT_GUILLEMET;
						break;

						
                    case '{' :  /*cas d'une accolade ouvrante*/
                    	if (previousCharacters[0] != '\n' && previousCharacters[0] != ';' && previousCharacters[0] != '}')
						putchar('\n');
	
                    	indentText();
						putchar(c);
						putchar('\n');
						indent++;
						
						accolade++;
   						etat = ETAT_DEBUT_LIGNE;

        				setCharacter(c);
                    	break;
                    
                    case '}' : /*cas d'une accolade fermante*/
                    	if (previousCharacters[0] != '\n' && previousCharacters[0] != ';' && previousCharacters[0] != '}')
	                    	putchar('\n');
	                    
	                    indent--;       
	                    indentText();
                    	putchar(c);
                    	putchar('\n');
                    	
                    	accolade--;
                    	etat = ETAT_DEBUT_LIGNE;

        				setCharacter(c);
                    	break;
                    	
                   case '\0': /*cas de fin de fichier*/
                    	break;
                    	
                    default : /*sinon*/
                        putchar(c);

        				setCharacter(c);
                        break;
        		}
        		break;
        	
        	case ETAT_DEBUT_COMMENTAIRE :
        		switch(c)
        		{
        			case ' ' :
        				break;
        				
        			case '\t' :
        				break;
        			
        			default :
        				putchar(' ');
        				putchar(c);
        				
        				setCharacter(c);
        				etat = ETAT_COMMENTAIRE;
        				break;
        		}
        		break;
        		
        	case ETAT_COMMENTAIRE :
        		switch(c)
        		{		
        			case '\n' : /* cas de retour a la ligne sans fin de commentaire*/
        				if (previousCharacters[1] == '*' && previousCharacters[0] == '/')
        				{
        					putchar(c);
        				}
        				else
        				{
        					if (previousCharacters[2] != ' ')
        						putchar(' ');
        						
        					putchar('*');
        					putchar('/');
        					putchar('\n');
        					indentText();
        					putchar('/');
        					putchar('*');
        					fputs("commentaire non fini détecté à la ligne : "+ligne,stderr);
        					nbErreur++;
        				}


        				setCharacter(c);
        				etat = ETAT_DEBUT_COMMENTAIRE;
        				break;
        		
        			case '/' : /* cas de fin de commentaire */
        				if (previousCharacters[0] == '*')
        				{
        					if (previousCharacters[1] != ' ')
        						putchar(' ');
        						
        					etat = ETAT_DEBUT_LIGNE;
	        				putchar('/');
	        				putchar('\n');
	        			}
	        			else
	        			{
	        				putchar('/');
	        			}


        				setCharacter(c);
	        			break;
	        			
	        		case '\0': /*cas de fin de fichier*/
                    	break;
                    	
        			default : /* sinon */

        				setCharacter(c);
        				putchar(c);
        				break;
        		}
        		break;

				case  ETAT_GUILLEMET :
					switch (c)
					{
						case '"' :

							setCharacter(c);
							putchar(c);
							etat = ETAT_NORMAL;
							break;
						default : /* sinon */

							setCharacter(c);
							putchar(c);
							break;
					}
					break;


				case ETAT_SIMPLE_QUOTE :
					switch (c)
					{
						case '\'' :

							if (previousCharacters[0] == '\\' || ( previousCharacters[0] == '\\' && previousCharacters[1] == '\\' ))
							{
								putchar(c);

								etat = ETAT_SIMPLE_QUOTE;
							}else
							{
								putchar(c);
								etat = ETAT_NORMAL;
							}
							setCharacter(c);
							break;
						default : /* sinon */
							setCharacter(c);
							putchar(c);
							break;
					}
					break;


				case  ETAT_DIESE :
					switch (c)
					{
						case '\n' :

							setCharacter(c);
							putchar(c);
							etat = ETAT_DEBUT_LIGNE;
							break;
						default : /* sinon */

							setCharacter(c);
							putchar(c);
							break;
					}
					break;
					case  ETAT_OPERATOR :
						switch (c)
						{
							case ')' :
								setCharacter(c);
								putchar(c);
								etat = ETAT_NORMAL;
								break;
							default : /* sinon */

								setCharacter(c);
								putchar(c);
								break;
						}
						break;
   		}
   	}
   	
   	if (accolade != 0)
   	{
    	if (accolade > 0) 
   			fputs("too much {" ,stderr);
   		else 
   			fputs("too much }" ,stderr);
   			
   		exit(EXIT_FAILURE);
    }
   	else if (nbErreur != 0)
   	{
   		printf("there are %d errors\n", nbErreur);
   		
   		exit(EXIT_FAILURE);
   	}

   	exit(EXIT_SUCCESS);

}
