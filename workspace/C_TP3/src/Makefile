CC	= gcc -ansi -pedantic
CFLAGS = -Wall -Werror
CFLAGS += -g


mgrep: mgrep.o 
	$(CC) $(CFLAGS) mgrep.c readl.c readl.h -o mgrep
mlook: mlook.o
	$(CC) $(CFLAGS) mlook.c readl.c readl.h -o mlook
mcut: mcut.o
	$(CC) $(CFLAGS) mcut.c readl.c readl.h -o mcut
mcolrm: mcolrm.o
	$(CC) $(CFLAGS) mcolrm.c readl.c readl.h -o mcolrm

all: mgrep mlook mcut mcolrm

.PHONY: clean realclean
clean:
	 rm *.o
realclean : clean 
	rm mgrep mlook mcut mcolrm
 
