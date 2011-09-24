/*
 ============================================================================
 Name        : TP1.c
 Author      : Benjamin Van Ryseghem
 Version     :
 Copyright   : MIT
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#define  DEBUG

#ifdef DEBUG
	#define debug(...) do{ fprintf( stderr, __VA_ARGS__ ); } while( 0 )
#else
	#define debug(...) do{ } while ( 0 )
#endif

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int canPrettyPrint = 1;
int currentIndent = 0;
char indent[4] = "    ";

void insertTab(){
	int i;
	for (i = 0; i < currentIndent; i++){
		printf("%s", indent);
	}
}



char internRule(char c){

	if ( c == '#' ){
		char tmp;
		tmp = getchar ();
		while ( ((tmp = getchar()) != EOF) & (tmp != '\n')){ printf("%c",c);}
		printf("\n");
	}
	if ( c == '\n' ){
		char tmp;
		tmp = getchar ();
		while (( tmp != EOF) && (!isalpha(tmp))) tmp = getchar();
		printf("\n");
		insertTab();
		return tmp;
	}

	if ( c == '{' ){
		printf("{\n");
		insertTab();
		currentIndent++;
		return 0;
	}

	if ( c == '}' ){
		currentIndent--;
		printf("\n");
		insertTab();
		printf("}\n");
		return 0;
	}

	printf("%c",c);

	return 0;
}


void prettyPrint(){

	char currentChar;
	char previousChar;
	char result;
	currentChar = getchar();
	previousChar = currentChar;

	debug("currentChar = %c\n",currentChar);

	while ( currentChar == ' ' ){
		currentChar = getchar();
	}


	debug("currentChar2 = %c\n",currentChar);

	while ( currentChar != EOF ){
		// if I encounter a token \", it toggles the pretty print
		if (( currentChar == '\"' ) & ( previousChar != '\\') ){
			canPrettyPrint = ! canPrettyPrint;
		}
		// if i encounter the token \*, I stop to pretty print
		if (( previousChar == '\\') & ( currentChar == '*' )){
				canPrettyPrint = 0;
				printf("\n");
		}
		// if i encounter the token */, I restart to pretty print
		if ((previousChar == '*' ) & (currentChar == '\\')){
			canPrettyPrint = 1;
			printf("\n");
		}
		// if I have to pretty print, I call the internal rule for special tokens
		if( canPrettyPrint ){
			result = internRule( currentChar );
		}
		else{
			// else I basically print the character without any further side effect
			printf("%c",currentChar);
			result = 0;
		}
		// I set the previousChar to the value of currentChar before incrementing it
		previousChar = currentChar;
		if ( result == 0 ){
			// if I haven't consume extra char form the stack, I just pursue naturally
			currentChar = getchar();
		}
		else{
			// else I re-inject the extra consume value in the loop
			currentChar = result;
		}
	}
}

int main(void) {
prettyPrint();
	return 0;
}
