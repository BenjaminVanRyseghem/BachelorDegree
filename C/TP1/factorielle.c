#include<stdlib.h>
#include<stdio.h>

#ifdef RECURSIVE

unsigned int factorielle_recursive (unsigned int n) {

        if ( n < 2 ) return 1;
        return n*factorielle_recursive(n-1);
}

unsigned int factorielle (unsigned int n) {
	return factorielle_recursive(n);
}

#else
unsigned int factorielle_iterative (unsigned int n) {

	unsigned int i = 1, res = 1;
	while (i < n) res = res * i++;
	return res;
}

unsigned int factorielle (unsigned int n) {
	return factorielle_iterative(n);
}
#endif

int main (){
	printf("%d\n",factorielle(10));
	return 0;
}
