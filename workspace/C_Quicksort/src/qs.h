/*
 ============================================================================
 Name        : qs.h
 Author      : Benjamin Van Ryseghem & Francois Lepan
 Version     : 1.0
 Copyright   : MIT
 ============================================================================
 */

#ifndef QS_H_
#define QS_H_

#define TABSIZE 20
#define MAX_RAND 10

void quicksort(void *base, int nelem, int size,int(*compar)(const void *, const void *));
void swapElem(void *x,void *y);

#endif /* QS_H_ */
