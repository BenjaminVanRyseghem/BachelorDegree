/*
 ============================================================================
 Name        : readl.c
 Author      : Francois Lepan & Benjamin Van Ryseghem
 Version     :
 Copyright   : MIT
 Description :
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "readl.h"


void error(char* errorMessage){
	fprintf(stderr, "%s\n", errorMessage);
	exit(0);
}

int readl(char* line){
/*	int size = sizeof(line);
	if(size < MAXLINE){
		printf("%d\n", sizeof(line));
		error("Wrong size");
	}*/
	if(fgets(line, MAXLINE, stdin) == NULL){
		if(ferror(stdin)) error("Error while reading");
		if(feof(stdin)) return 0;
	}
	return strlen(line);
}


/*int main(void) {
	char test[MAXLINE];

	while(readl(test)!= 0){
		printf("%s",test);
	}
	return 1;
} */
