/*
 ============================================================================
 Name        : mcolrm.c
 Author      : Francois Lepan & Benjamin Van Ryseghem
 Version     :
 Copyright   : MIT
 Description :
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "readl.h"

void mcolrm(int begin, int end){

	int maxLength;
	char line[MAXLINE];
	while((maxLength=readl(line)) != 0){
		int index = 0;
		while(index < maxLength){
			if (index < begin-1 || index > end-1) printf("%c",line[index]);
			index++;
		}
	}
}


int main(int argc,char** argv) {

	if (argc == 1){
		mcolrm(-1,-1);
	}else if (argc == 2){
		int index = atoi(argv[1]);
		mcolrm (index,index);
	}else if (argc == 3){
		int begin = atoi(argv[1]);
		int end = atoi(argv[2]);
		mcolrm(begin,end);
	} else error("Wrong number of args");
	return 1;
}
