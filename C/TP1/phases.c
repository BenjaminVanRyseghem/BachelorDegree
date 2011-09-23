/* ------------------------------
Mon premier programme
------------------------------------------------------------ */
#include <stdio.h>
#include <stdlib.h>
#define MAX 12
int foo = 3;
const int bar = 5;
extern int gee;

int
main()
{
	int bzu; /* declaration et definition de bzu */
	bzu = MAX;
	printf("Hello : %d\n", foo + bar + bzu);
	exit(EXIT_SUCCESS);
}