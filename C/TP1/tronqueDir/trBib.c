#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>


int maxSize = 60;
void tronque(){
	char currentChar;
	int hasEncounteredSpace = 0;
	int counter = 0;

	while((currentChar = getchar()) != EOF){
		if (currentChar == '\n') counter = -1;
		if ((counter > maxSize) && (!isalpha(currentChar))) hasEncounteredSpace = 1;
		if ((counter > maxSize) && hasEncounteredSpace && (isalpha(currentChar))){
			counter = 0;
			hasEncounteredSpace = 0;
			printf("\n%c",currentChar);
		}
		else{
			counter ++;
			printf("%c",currentChar);
		}
	}

}
