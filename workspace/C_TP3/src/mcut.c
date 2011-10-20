/*
 ============================================================================
 Name        : mcut.c
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


int * buildColumnNumbers(int argc, char** argv){
	int* result = (int*)malloc(sizeof(int)*argc-2+1);
	int i;
	for(i = 0 ; i < argc-2; i++){
		result[i] = atoi(argv[i+2]);
	}
	result[argc-2] = -1;
	return result;
}


int include(int index, int* list){
	int i = 0;
	int current;
	while((current=list[i++]) != -1) if(index == current) return 1;
	return 0;
}

void mcut(char delim, int *columnNumbers){
	int maxLength;
	char line[MAXLINE];
	while((maxLength=readl(line)) != 0){
		int index = 0;
		int columnIndex = 0;
		while(index < maxLength){
			if (include(columnIndex+1, columnNumbers)) (line[index] != delim) ? printf("%c",line[index]):printf(" ");
			if(line[index] == delim) columnIndex ++;
			index++;
		}
		printf("\n");
	}
	free(columnNumbers);

}


int main(int argc,char** argv) {
	if (argc > 2){
		mcut(argv[1][0],buildColumnNumbers(argc, argv));
	} else error("Wrong number of args");
	return 1;
}
