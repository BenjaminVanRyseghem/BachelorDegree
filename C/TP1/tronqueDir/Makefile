CC	= gcc -ansi -pedantic
CFLAGS = -Wall -Werror
CFLAGS += -g

OBJ	= trBib.o tronque.o

tronque: $(OBJ)
	$(CC) $(CFLAGS) -o $@ $(OBJ)

.PHONY: clean realclean
clean:
	$(RM) $(OBJ)
realclean : clean
	$(RM) tronque
