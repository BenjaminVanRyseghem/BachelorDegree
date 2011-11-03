/*
 ============================================================================
 Name        : qsint.h
 Author      : Benjamin Van Ryseghem & Francois Lepan
 Version     : 1.0
 Copyright   : MIT
 ============================================================================
 */

#ifndef QSINT_H_
#define QSINT_H_

	#define TABSIZE 20
	#define MAX_RAND 10

	int rand (void);
	void quicksort_int(int tab[], unsigned int nelem);
	void quicksort_int_rec(int tab[],int beg, int end);

#endif /* QSINT_H_ */
