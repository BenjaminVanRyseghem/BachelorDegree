#!/bin/sh
java java_cup.Main -parser ParserInit -symbols TypeSymboles spec/anSyntInit.cup
mv TypeSymboles.java ParserInit.java src/init/analyseurs