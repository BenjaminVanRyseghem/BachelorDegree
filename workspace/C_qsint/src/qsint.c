/*
 ============================================================================
 Name        : qsint.c
 Author      : Benjamin Van Ryseghem & Francois Lepan
 Version     : 1.0
 Copyright   : MIT
 ============================================================================
 */
#include <stdio.h>
#include <stdlib.h>
#include "qsint.h"

void swapElemInt(int *x,int *y)
{
   int temp;
   temp = *x;
   *x = *y;
   *y = temp;
}

void printTabInt(int tab[],int n)
{
   int i;
   for(i=0;i<n;i++)
      printf("%d ",tab[i]);

   printf("\n");
}

void quicksort_int(int tab[], unsigned int nelem){
	quicksort_int_rec(tab,0,nelem);
}

void quicksort_int_rec(int tab[],int beg,int end)
{
	int piv,y,z;

	if(beg < end)
	{
		piv = tab[beg];
		y = beg;
		z = end;

		while(y < z)
		{
			while((y <= end) && (tab[y] <= piv))
				y++;

			while((z >= beg) && (tab[z] > piv))
				z--;

			if(y < z)
				swapElemInt(&tab[y],&tab[z]);
		}

		swapElemInt(&tab[beg],&tab[z]);

		quicksort_int_rec(tab,beg,z-1);
		quicksort_int_rec(tab,z+1,end);
	}
}



int main()
{
   int tab[TABSIZE];
   int i;

   for(i = 0; i < TABSIZE; i++ )
	   tab[i] = rand() % MAX_RAND;

   printf("The list before :\n");
   printTabInt(tab,TABSIZE);

   quicksort_int(tab,TABSIZE-1);

   printf("The list after  :\n");
   printTabInt(tab,TABSIZE);

   return 1;
}
