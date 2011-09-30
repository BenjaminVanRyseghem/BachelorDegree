#!/bin/sh
java java_cup.Main -parser ParserInit -symbols TypeSymboles /Users/benjamin/Documents/Scholarship/COMPIL/TP2/tp2/init/spec/anSyntInit.cup
mv TypeSymboles.java ParserInit.java /Users/benjamin/Documents/Scholarship/COMPIL/TP2/tp2/init/src/init/analyseurs