/*
 ============================================================================
 Name        : qs.c
 Author      : Benjamin Van Ryseghem & Francois Lepan
 Version     : 1.0
 Copyright   : MIT
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "qs.h"



void quicksort(void* base, int nelem, int size,int(*compar)(const void *, const void *)){

}

void swapElem(void *x,void *y)
{
   void* temp;
   temp = x;
   x = y;
   y = temp;
}

void quicksort_rec(void* base,int size, int beg,int end)
{
	void* piv;
	int y,z;

	if(beg < end)
	{
		piv = base;
		y = beg;
		z = end;

		while(y < z)
		{
			while((y <= end) && (base+(y*size) <= piv))
				y++;

			while((z >= beg) && (base+(z*size) > piv))
				z--;

			if(y < z)
				swapElem(base+(y*size), base+(z*size));
		}

		swapElem(base+(beg*size),base+(z*size));

		quicksort_rec(base, size, beg, z-1);
		quicksort_rec(base, size, z+1, end);
	}
}





void printTab(void* base,int nelem, int size, char* (*print)(void*))
{
	void * index;
	int i;
	index = base;

	for(i=0;i<nelem;i++){
	   printf("%s ",print(index));
   	   index += size;
	}

   printf("\n");
}







/* ================================================================================*/

char* generateWord(int size){
//	printf("size = %i\n",size);
	char* result = (char*)malloc((size)*sizeof(char));
	int i;
	for (i = 0; i < size-1 ; i++){
		char car = 65+rand()%4;
	//	printf("%c",car);
		result[i]=car;
	}
	//printf (" - ");
	result[size-1]='\0';
	return result;
}


int main (){
	int size = 5;
	void* tab = malloc(TABSIZE*MAX_RAND*sizeof(char));
	char** index = (char**)tab;

	int i;
	int cpt = 0;

/*	for(i = 0; i < TABSIZE; i++ ){
			int size = 5;
			char* word = generateWord(size);

			*index = word;
			printf("%d- %d, %s - %s\n", i,cpt, word, *index);
			printf("%s\n",((char**)tab)[cpt]);
			cpt += size;
			index += size;
		}
*/

	for(i = 0; i < TABSIZE; i++ ){
		int idx;
		char* word = generateWord(size);
		for(idx = 0 ; idx < size; idx++){
			((char*)tab)[cpt] = word[idx];
			cpt++;
		}
		//printf("%s\n",((char**)tab)[cpt-size]);
	}
	//if(1){return 1;}
/*	for(i = 0; i < cpt; i++ ){
			char car = ((char*)tab)[i];
			printf("%c\n",car);
		}
*/
	//if(1){return 1;}

	printf("%s\n",(char*)tab);

	int idx = 0;
	index = (char**)tab;;

	for(i = 0; i < TABSIZE; i++ ){
			char* string = &((char*)tab)[idx];
			printf("%d: %s(%d)\n",i,string,size);
			idx += size;
		}

	int comparString(void* a, void* b){
		return strcmp((char*)a, (char*)b);
	}

	quicksort(tab, cpt, size,&comparString);

	return 1;
}

/*int main()
{
	   int tab[TABSIZE];
	   int i;

	   for(i = 0; i < TABSIZE; i++ )

		   tab[i] = generateWord(rand() % MAX_RAND);

	   printf("The list before :\n");
	   printTabInt(tab,TABSIZE);

	   quicksort_int(tab,TABSIZE-1);

	   printf("The list after  :\n");
	   printTabInt(tab,TABSIZE);

	   return 1;
}*/
