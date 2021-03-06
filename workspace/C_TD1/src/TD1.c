/*
 ============================================================================
 Name        : TD1.c
 Author      : Benjamin Van Ryseghem
 Version     :
 Copyright   : MIT
 Description :
 ============================================================================
 */

/*#define  DEBUG*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <ctype.h>


#ifdef DEBUG
	#define DEBUG_PRINT(...) do{ fprintf( stderr, __VA_ARGS__ ); } while( 0 )
#else
	#define DEBUG_PRINT(...) do{ } while ( 0 )
#endif


#define VRAI 			1
#define FAUX 			0


#define CHIFROUMAJ(c) 	printf ("%c est ",c); if ((c > 47) & (c < 58)) { printf("un chiffre\n"); } else { if ((c > 64) & (c < 91)){ printf ("une majuscule\n");}else{printf("ni un chiffre ni une majuscule\n");}}
#define max(a, b)       ((a) < (b) ? (b) : (a))


unsigned int factorielle_it(unsigned int n){

	unsigned int result;
	result = 1;

	while (n){
		result *= n--;
	}

return result;
}

unsigned int factorielle_rec(unsigned int n){

	if ( n>1 ){
		return n*factorielle_rec( n-1 );
	}
	return 1;
}

int checkParentheses(){
	int cpt;
	char currentChar;
	cpt = 0;
	currentChar = getchar();
	DEBUG_PRINT("cpt = %d\n",cpt);
	while( currentChar != EOF ){
		if (currentChar == '('){
			cpt++;
			DEBUG_PRINT("cpt ++; cpt = %d\n",cpt);
		}
		if (currentChar == ')'){

			if (cpt == 0){
				exit(EXIT_FAILURE);
			}
			else{
				cpt --;
				DEBUG_PRINT("cpt--; cpt = %d\n",cpt);
			}
		}
		currentChar = getchar();
	}
	if (cpt) exit(EXIT_SUCCESS);
	exit(EXIT_FAILURE);
}

int numberOfWords(){
	int result;
	char currentChar;
	char previousChar;
	result = 0;
	currentChar = getchar();
	previousChar = currentChar;
	while (currentChar != EOF ){
		if (((currentChar == ' ') || (currentChar == '\n') || (currentChar == '\'')) && (previousChar != ' ') && (previousChar != '\n') && (previousChar != '\'') ){
			result ++;
		}
		previousChar = currentChar;
		currentChar = getchar();
	}
	return result;
}


int readInt(){
	char currentChar;
	int size = 5;
	int nbOfRealloc = 1;
	int index = 0;
	int i;
	int result = 0;

	char* str = (char*) malloc(nbOfRealloc * size);
	while ((currentChar = getchar()) && isdigit(currentChar)){
		str[index] = currentChar;
		index ++;
		if ( index == (nbOfRealloc * size) - 1){
			nbOfRealloc ++;
			str = realloc(str, nbOfRealloc * size);
		}
	}
	for( i=0; i < index ; i++){
		result = result + (str[i]-'0')*pow(10,index-i-1);
	}
	free(str);
	return result;
}


int numberOfLines(){

	int result;
	char currentChar;
	result = 0;
	currentChar = getchar();

	while (currentChar != EOF){
		while ((currentChar != '\n') & (currentChar != EOF) ){
			currentChar = getchar();
		}
		result++;
		currentChar = getchar();
	}
	return result;
}

int maxLine(){

	int result;
	char currentChar;
	int currentTmp;

	result = 0;
	DEBUG_PRINT("before first getchar\n");
	currentChar = getchar();
	DEBUG_PRINT("after first getchar, currentChar = %c\n", currentChar);

	while( currentChar != EOF ){
		DEBUG_PRINT("beginning of the loop\n");
		currentTmp = 0;
		while ((currentChar != '\n') & (currentChar != EOF )){
			currentTmp ++;
			currentChar = getchar();
			DEBUG_PRINT("currentChar = %c\n", currentChar);
		}
		DEBUG_PRINT("end of line\n");
		DEBUG_PRINT("currentTMP = %d\n", currentTmp);
		result = max(result, currentTmp);
		currentChar = getchar();
		DEBUG_PRINT("currentChar = %c\n", currentChar);
	}
	DEBUG_PRINT("end of file\n");
	return result;
}


void affichebin(unsigned int n)
{
	int position;
	int maxSize = sizeof(unsigned int)*8-1;
	unsigned mask = ((unsigned int)1) << maxSize;
	for ( position = maxSize ; position >= 0 ; position--)
	{
		putchar((n & mask)? '1': '0');
		mask >>= 1;
	}
}

char * bin (unsigned long int i)
{
    static char buffer [1+sizeof (unsigned long int)*8] = { 0 };
    char *p=buffer-1+sizeof (unsigned long int)*8;
    do { *--p = '0' + (i & 1); i >>= 1; } while (i);
    return p;
}

int main(int argc, char** argv){
/*
	int input;
	printf("Enter an integer: ");
	scanf("%d", &input );

	printf("Entered Value: %d\n", input);
	printf("Iteratif factorial: %d\n", factorielle_it(input));
	printf("Recursif factorial: %d\n", factorielle_rec(input));
	*/
//	printf("%d\n", numberOfWords());
//	printf("parentheses : %d\n",checkParentheses());
/*	int c = 0;
	for (c = 0 ; c < 128 ; c++){
		CHIFROUMAJ((char)c);
	}
*/

	int i;
	i = 5;
//	printf("%d s'ecrit %s en binaire\n", i, bin(i));
	printf("%d s'ecrit en binaire: ", i);
	affichebin(i);
	printf("\n");
	printf("%d\n",isalpha('\''));
	return 0;
}
