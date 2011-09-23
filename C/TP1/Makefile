CC	= gcc -ansi -pedantic
CFLAGS = -Wall -Werror
CFLAGS += -g

OBJ	= fbib.o fact.o

fact: $(OBJ)
	$(CC) $(CFLAGS) -o $@ $(OBJ)

.PHONY: clean realclean
clean:
	$(RM) $(OBJ)
realclean : clean
	$(RM) fact

