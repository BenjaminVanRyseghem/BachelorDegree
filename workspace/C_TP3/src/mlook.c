/*
 ============================================================================
 Name        : mlook.c
 Author      : Francois Lepan & Benjamin Van Ryseghem
 Version     :
 Copyright   : MIT
 Description :
 ============================================================================
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "readl.h"


void mlook(char* word){
	int maxLength;
	char line[MAXLINE];
	while((maxLength=readl(line)) != 0){
		char* found = strstr(line, word);
		if (found == line){
			printf("%s",line);
		}
	}
}

int main(int argc,char** argv) {
	if (argc > 2) error("Wrong number of args");
		mlook(argv[1]);
	return 1;
}
