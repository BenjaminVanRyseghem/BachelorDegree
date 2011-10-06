#!/bin/sh
java JFlex.Main spec/lexiquePlanning.lex
mv spec/ScannerPlanning.java src/planningMaster/analyseurs