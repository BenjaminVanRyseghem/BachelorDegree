#!/bin/sh
java java_cup.Main -parser ParserPlanning -symbols TypeSymboles spec/syntaxePlanning.cup
mv TypeSymboles.java ParserPlanning.java src/planningMaster/analyseurs